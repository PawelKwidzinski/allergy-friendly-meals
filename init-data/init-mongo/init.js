db = db.getSiblingDB('ingredients_db');
const data = JSON.parse(fs.readFileSync('/docker-entrypoint-initdb.d/output.json', 'utf8'));
db.histamine_foods.insertMany(data);