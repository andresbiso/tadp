const express = require("express");
const app = express();
const http = require("http").createServer(app);
const PORT = 5000;

const username = encodeURIComponent("mongo");
const password = encodeURIComponent("Pass1234");
const cluster = encodeURIComponent("cluster0.vh6w9om.mongodb.net");
const db = encodeURIComponent("tap2022");

const async = require('async');
const { ServerApiVersion } = require('mongodb');
const mongoose = require('mongoose');
const Menu = require('./modelos/menu');
const Hamburguesa = require('./modelos/hamburguesa');
const PapasFritas = require('./modelos/papas_fritas');

const uri = `mongodb+srv://${username}:${password}@${cluster}/${db}?retryWrites=true&w=majority`;
const hamburguesasMenu = [];
const papasFritasMenu = [];

app.use(express.json());

async function run() {
    try {
        mongoose.connect(uri, { useNewUrlParser: true, useUnifiedTopology: true, serverApi: ServerApiVersion.v1 });
        crearModelo();
    } catch(err) {
        console.log(err);
    }
}

run().catch(console.dir);

http.listen(PORT,() =>{
    console.log(`listening to ${PORT}`);
})

app.get("/burgers/:offset/:limit", async (req,res) =>{
    let { limit = 5, offset = 0 } = req.params;
    console.log(limit);
    try {
        const query = Hamburguesa.find({}).skip(offset).limit(limit);
        const callback = function(err, data) {
            if (err) {
                console.log(err);
                return;
            }
            res.json({burgers: data});
        }
        query.exec(callback);
    } catch(error) {
        console.error(`Ocurrió un error: ${error}`);
    }    
})

app.get("/frenchfries/:offset/:limit", async (req,res) =>{
    let { limit = 5, offset = 0 } = req.params;
    console.log(limit);
    try {
        const query = PapasFritas.find({}).skip(offset).limit(limit);
        const callback = function(err, data) {
            if (err) {
                console.log(err);
                return;
            }
            res.json({french_fries: data});
        }
        query.exec(callback);
    } catch(error) {
        console.error(`Ocurrió un error: ${error}`);
    }    
})

app.get("/menus/:offset/:limit", async (req,res) =>{
    let { limit = 5, offset = 0 } = req.params;
    console.log(limit);
    try {
        const query = Menu.aggregate([
            { $match: {} }
        ])
        .lookup({
            from: 'burgers',
            localField: 'burgers',
            foreignField: '_id',
            as: 'burgers'
        })
        .lookup({
            from: 'frenchfries',
            localField: 'french_fries',
            foreignField: '_id',
            as: 'french_fries'
        })
        .skip(parseInt(offset))
        .limit(parseInt(limit));
        const callback = function(err, data) {
            if (err) {
                console.log(err);
                return;
            }
            res.json({menus: data});
        }
        query.exec(callback);
    } catch(error) {
        console.error(`Ocurrió un error: ${error}`);
    }    
})


function crearModelo() {
    // Limpiar Modelo
    async.series([
        function(callback) {
            Hamburguesa.deleteMany({}).then(function(){
                console.log("Burgers deleted");
                callback(null, null);
            }).catch(function(error){
                console.log(error);
            });
        },
        function(callback) {
            PapasFritas.deleteMany({}).then(function(){
                console.log("FrenchFries deleted");
                callback(null, null);
            }).catch(function(error){
                console.log(error);
            });
        },
        function(callback) {
            Menu.deleteMany({}).then(function(){
                console.log("Menus deleted");
                callback(null, null);
            }).catch(function(error){
                console.log(error);
            });
        }
    ], function() {
        createBurgers();
    });
}

function createBurgers() {
    async.series([
        function(callback) {
            createHamburguesa('Big Mc', ['medallón de carne', 'lechuga', 'salsa big mc'], 20).then(function() {
                console.log('Se ha creado hamburguesa Big Mc');
                callback(null, null)
            });
        },
        function(callback) {
            createHamburguesa('Super Mc', ['medallón de carne', 'lechuga', 'tomate'], 20).then(function() {
                console.log('Se ha creado hamburguesa Super Mc');
                callback(null, null)
            });;
        },
        function(callback) {
            createHamburguesa('Cheese Mc', ['medallón de carne', 'queso'], 20).then(function() {
                console.log('Se ha creado hamburguesa Cheese Mc');
                callback(null, null)
            });;
        }
    ], function() {
        createFrenchFries();
    });
}

function createFrenchFries() {
    async.series([
        function(callback) {
            createPapasFritas('Simple', 10).then(function() {
                console.log('Se ha creado papas fritas Simple');
                callback(null, null)
            });
        },
        function(callback) {
            createPapasFritas('Grande', 12).then(function() {
                console.log('Se ha creado papas fritas Grande');
                callback(null, null)
            });;
        }
    ], function() {
        createMenus();
    });
}

function createMenus() {
    async.series([
        function(callback) {
            Hamburguesa.find({name: 'Big Mc'}).then(function(data, err) {
                hamburguesasMenu.push(data[0]._id);
                callback(null, null);
            });
        },
        function(callback) {
            Hamburguesa.find({name: 'Super Mc'}).then(function(data, err) {
                hamburguesasMenu.push(data[0]._id);
                callback(null, null);
            });
        },
        function(callback) {
            PapasFritas.find({name: 'Simple'}).then(function(data, err) {
                papasFritasMenu.push(data[0]._id);
                callback(null, null);
            });
        },
        function(callback) {
            PapasFritas.find({name: 'Grande'}).then(function(data, err) {
                papasFritasMenu.push(data[0]._id);
                callback(null, null);
            });
        },
    ], function() {
        createMenu('Menú Clásico', hamburguesasMenu, papasFritasMenu).then(function() {
            console.log('Se ha creado menú clásico');
        });
    });
}

function createHamburguesa(name, ingredients, price) {
    var hamburguesa = new Hamburguesa({ name: name, ingredients: ingredients, price: price });
    return hamburguesa.save();
}

function createPapasFritas(name, price) {
    var papasFritas = new PapasFritas({ name: name, price: price });
    return papasFritas.save();
}

function createMenu(name, burgers, frenchFries) {  
    var menu = new Menu({ name: name, burgers: [...burgers], french_fries: [...frenchFries] });
    return menu.save();
}
  
