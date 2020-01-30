    package fi.vamk.e1800935.spring3;

    import org.springframework.data.repository.CrudRepository;
    /* Repository is the interface that communicated with database
    Note that it's inherited from CRUDRepository that already knows how
    to save , findAll, findById*/ 
    public interface PartnerRepository extends CrudRepository<Partner, Integer> {

    }