package session;

import entity.Training;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TrainingFacadeLocal {

    void create(Training training);

    void edit(Training training);

    void remove(Training training);

    Training find(Object id);

    List<Training> findAll();

    List<Training> findRange(int[] range);

    int count();
    
}
