package you.ru.controller;

import you.ru.model.Worker;
import you.ru.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WorkerController {

    private final WorkerService workerService;
    private final DepartmentService departmentService;

    @Autowired
    public WorkerController(WorkerService workerService, DepartmentService departmentService) {
        this.workerService = workerService;
        this.departmentService = departmentService;
    }

    @GetMapping("/workers")
    public String findAll(Model model){
        List<Worker> workers = workerService.findAll();
        model.addAttribute("workers", workers);
        return "worker-list";
    }

    @GetMapping("/worker-create")
    public String createWorkerForm(Worker worker, Model model){
        model.addAttribute("departments", departmentService.findAll());
        return "worker-create";
    }

    @PostMapping("/worker-create")
    public String createWorker(Worker worker){
        workerService.saveWorker(worker);
        return "redirect:/workers";
    }

    @GetMapping("worker-delete/{id}")
    public String deleteWorker(@PathVariable("id") Long id){
        workerService.deleteById(id);
        return "redirect:/workers";
    }

    @GetMapping("/worker-update/{id}")
    public String updateWorkerForm(@PathVariable("id") Long id, Model model){
        Worker worker = workerService.findById(id);
        model.addAttribute("worker", worker);
        model.addAttribute("departments", departmentService.findAll());
        return "worker-update";
    }

    @PostMapping("/worker-update")
    public String updateWorker(Worker worker){
        workerService.saveStudent(worker);
        return "redirect:/workers";
    }
}
