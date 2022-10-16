const mongoose = require('mongoose');
const { Schema, model } = mongoose;

const menuSchema = new Schema({
  name:  { type: String },
  burgers: [{ type: Schema.Types.ObjectId, ref: 'Burger' }],
  french_fries: [{ type: Schema.Types.ObjectId, ref: 'FrenchFry' }],
});

const Menu = model('Menu', menuSchema);
module.exports = Menu;