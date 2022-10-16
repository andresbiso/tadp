const mongoose = require('mongoose');
const { Schema, model } = mongoose;

const frenchFrySchema = new Schema({
  name: { type: String },
  price: { type: Number }
});

const PapasFritas = model('FrenchFries', frenchFrySchema);
module.exports = PapasFritas;