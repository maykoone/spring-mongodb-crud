package dao.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import entidades.mongodb.Contato;

@Repository
public class MongoDbContatoDao extends MongoDbBaseDao<Contato> implements
		ContatoDao {

	@Autowired
	private MongoOperations mongoTemplate;

	public MongoDbContatoDao() {
		super(Contato.class);
	}

	@Override
	public MongoOperations getMongoOperations() {
		return mongoTemplate;
	}

}
