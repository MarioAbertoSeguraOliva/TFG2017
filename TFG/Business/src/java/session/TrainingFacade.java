package session;

import entity.Training;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TrainingFacade extends AbstractFacade<Training> implements TrainingFacadeLocal {

    @PersistenceContext(unitName = "TFG-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrainingFacade() {
        super(Training.class);
    }
    
}
