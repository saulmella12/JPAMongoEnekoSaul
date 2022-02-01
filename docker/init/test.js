conn = new Mongo();
// Nos vamos a la base de datos test,
// si no lo haría por defecto en la BD definida en el docker-compose.yml MONGO_INITDB_DATABASE
db = conn.getDB("test");
// Borramos todas las colecciones
// db.collection.drop();

// Y en la colección prueba creamos un índice e insertamos
db.prueba.createIndex({ "address.zip": 1 }, { unique: false });

db.Commits.insert({ "id":1,"titulo":"tituloPrueba","texto":"textoPrueba","fecha":"2222-22-22","idRepositorio":1,"idIssue":1,"idProyecto":1,"idCreador":1});
db.Departamentos.insert({ "id":1, "enCurso":(1),"nombre":"prueba",});
db.Issue.insert({"id":1,"titulo":"tituloPrueba","texto":"textoPrueba","fecha":"2222-22-22","programadores":[1],"commits":[1],"idProyecto":1,"idRepositorio":1,"terminado":true});
