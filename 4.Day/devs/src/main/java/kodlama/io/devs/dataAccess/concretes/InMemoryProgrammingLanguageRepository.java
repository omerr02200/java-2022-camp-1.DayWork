package kodlama.io.devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository{

	List<ProgrammingLanguage> languages;
	
	public InMemoryProgrammingLanguageRepository() {
		languages = new ArrayList<>();
		
		languages.add(new ProgrammingLanguage(1, "C#"));
		languages.add(new ProgrammingLanguage(2, "Pyhton"));
		languages.add(new ProgrammingLanguage(3, "Java"));
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return languages;
	}

	@Override
	public void add(ProgrammingLanguage language) throws Exception {
		languages.add(language);
	}

	@Override
	public void update(ProgrammingLanguage language) {
		int updatedId = language.getId();
		languages.get(updatedId).setName(language.getName());
	}

	@Override
	public void delete(ProgrammingLanguage language) {
		int deletedId = language.getId();
		languages.remove(deletedId);
	}

	@Override
	public ProgrammingLanguage getByid(int id) {
		return languages.get(id);
	}

}