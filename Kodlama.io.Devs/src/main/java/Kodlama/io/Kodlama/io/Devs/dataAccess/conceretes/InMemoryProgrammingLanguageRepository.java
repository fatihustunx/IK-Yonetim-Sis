package Kodlama.io.Kodlama.io.Devs.dataAccess.conceretes;
/**
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.springframework.stereotype.Repository;
 * 
 * import
 * Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
 * import Kodlama.io.Kodlama.io.Devs.entities.ProgrammingLanguage;
 * 
 * @Repository public class InMemoryProgrammingLanguageRepository implements
 *             ProgrammingLanguageRepository {
 * 
 *             List<ProgrammingLanguage> programmingLanguages;
 * 
 *             public InMemoryProgrammingLanguageRepository() {
 *             programmingLanguages = new ArrayList<ProgrammingLanguage>();
 *             programmingLanguages.add(new ProgrammingLanguage(1, "C++"));
 *             programmingLanguages.add(new ProgrammingLanguage(2, "Java")); }
 * 
 * @Override public void add(ProgrammingLanguage programmingLanguage) {
 * 
 *           programmingLanguages.add(programmingLanguage); }
 * 
 * @Override public void update(ProgrammingLanguage oldPLanguage,
 *           ProgrammingLanguage newPLanguage) {
 * 
 *           delete(oldPLanguage); add(newPLanguage); }
 * 
 * @Override public void delete(ProgrammingLanguage programmingLanguage) {
 * 
 *           programmingLanguages.remove(programmingLanguage); }
 * 
 * @Override public List<ProgrammingLanguage> getAll() {
 * 
 *           return programmingLanguages; }
 * 
 * @Override public ProgrammingLanguage getWithId(int id) {
 * 
 *           for (ProgrammingLanguage programmingLanguage :
 *           programmingLanguages) {
 * 
 *           if (programmingLanguage.getId() == id) { return
 *           programmingLanguage; } }
 * 
 *           return null; }
 * 
 *           }
 **/