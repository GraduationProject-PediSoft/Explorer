package co.edu.javeriana.pedisoft.algorithmexplorer.controller;

import co.edu.javeriana.pedisoft.algorithmexplorer.service.ExplorerService;
import com.netflix.discovery.shared.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class ExplorerController {
    @Autowired
    private ExplorerService explorerService;

    @GetMapping
    public Iterable<String> getAlgorithms(){
        return explorerService.filterAlgorithms();
    }
}
