package co.edu.javeriana.pedisoft.algorithmexplorer.service;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ExplorerService {

    @Autowired
    private DiscoveryClient discoveryClient;

    private static final String KEY = "microservice-type";
    private static final String VALUE = "IA-MODEL";

    /**
     * Filters the Registry for searching IA services in the system
     * @return an iterable with the names of the IA Services
     */
    public Iterable<String> filterAlgorithms() {
        return this.discoveryClient.getServices()
                .stream()
                .filter(e -> {
                    val instances = discoveryClient.getInstances(e);
                    if (!instances.isEmpty()) {
                        val metadata = instances.get(0).getMetadata();

                        if(metadata.get(KEY) != null){
                            return metadata.get(KEY).equals(VALUE);
                        }
                    }
                    return false;
                })
                .collect(Collectors.toSet());
    }
}
