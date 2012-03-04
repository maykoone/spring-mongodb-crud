package dao.mongodb;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.MongoOperations;

public abstract class MongoDbBaseDao<T> {
	private Class<T> clazz;

	public MongoDbBaseDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	public abstract MongoOperations getMongoOperations();

	public T save(T entity) throws DataAccessException {
		getMongoOperations().insert(entity);
		return entity;
	}

	public void remove(T entity) throws DataAccessException {
		getMongoOperations().remove(entity);
	}

	public T findById(ObjectId id) throws DataAccessException {
		return getMongoOperations().findById(id, clazz);
	}

	public List<T> findAll() throws DataAccessException {
		return getMongoOperations().findAll(clazz);
	}
}
