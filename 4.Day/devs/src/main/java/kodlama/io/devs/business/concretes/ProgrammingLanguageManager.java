package kodlama.io.devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

	ProgrammingLanguageRepository languageRepository;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return languageRepository.getAll();
	}

	@Override
	public void add(ProgrammingLanguage language) throws Exception {
		if(language.getName().isEmpty()) {
			throw new Exception("Kurs ismi boş geçilemez.");
		}
		for (ProgrammingLanguage language2 : getAll()) {
			if(language2.getId() == language.getId()) {
				throw new Exception("Aynı id zaten var.");
			}
			if(language2.getName().equals(language.getName())) {
				throw new Exception("Aynı isimde kurs zaten var.");
			}
		}
		languageRepository.add(language);
	}

	@Override
	public void update(ProgrammingLanguage language) {
		languageRepository.update(language);
	}

	@Override
	public void delete(ProgrammingLanguage language) {
		languageRepository.delete(language);
	}

	@Override
	public ProgrammingLanguage getByid(int id) {
		return languageRepository.getByid(id);
	}

}