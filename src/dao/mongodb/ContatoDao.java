package dao.mongodb;

import java.util.List;

import org.bson.types.ObjectId;

import entidades.mongodb.Contato;

public interface ContatoDao {

	Contato save(Contato contato);

	void remove(Contato contato);

	Contato findById(ObjectId id);

	List<Contato> findAll();

}
