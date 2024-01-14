package you.ru.service;

import you.ru.model.Worker;
import you.ru.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public Worker findById(Long id){
        return workerRepository.getOne(id);
    }

    public List<Worker> findAll(){
        return workerRepository.findAll();
    }

    public Worker saveWorker(Worker worker){
        return workerRepository.save(worker);
    }

    public void deleteById(Long id){
        workerRepository.deleteById(id);
    }
}
