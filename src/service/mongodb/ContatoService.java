package service.mongodb;

import java.util.List;

import org.bson.types.ObjectId;

import entidades.mongodb.Contato;



public interface ContatoService {

	public abstract Contato save(Contato contato);

	public abstract void remove(Contato contato);

	public abstract Contato findById(ObjectId id);

	public abstract List<Contato> list();

}