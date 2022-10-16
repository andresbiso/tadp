const mongoose = require('mongoose');
const { Schema, model } = mongoose;

const burgerSchema = new Schema({
  name: { type: String },
  ingredients: [{type: String}],
  price: { type: Number }
});

const Hamburguesa = model('Burgers', burgerSchema);
module.exports = Hamburguesa;