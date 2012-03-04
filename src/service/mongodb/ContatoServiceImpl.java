package service.mongodb;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import dao.mongodb.ContatoDao;
import entidades.mongodb.Contato;

@Service
public class ContatoServiceImpl implements ContatoService {

	private ContatoDao contatoDao;

	public void setContatoDao(ContatoDao contatoDao) {
		this.contatoDao = contatoDao;
	}

	@Override
	public Contato save(Contato contato) {
		return contatoDao.save(contato);
	}

	@Override
	public void remove(Contato contato) {
		contatoDao.remove(contato);
	}

	@Override
	public Contato findById(ObjectId id) {
		return contatoDao.findById(id);
	}

	@Override
	public List<Contato> list() {
		return contatoDao.findAll();
	}
}
