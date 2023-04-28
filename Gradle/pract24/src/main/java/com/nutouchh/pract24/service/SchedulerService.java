package com.nutouchh.pract24.service;

import com.nutouchh.pract24.model.Market;
import com.nutouchh.pract24.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
@Slf4j
@ManagedResource
public class SchedulerService {
    private final String DIRECTORY = "src/backups/";
    private final ProductService productService;
    private final MarketService marketService;
    @Autowired
    public SchedulerService(ProductService productService, MarketService marketService) throws NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, MalformedObjectNameException {
        this.productService = productService;
        this.marketService = marketService;
    }

    @ManagedOperation
//    @Scheduled(cron = "0 * * * * *")
    @Scheduled(cron = "0 */30 * * * *")
    public void makeBackup() throws IOException {
        log.info("Scheduled task started: deleting files");
        File backupDir = ResourceUtils.getFile(DIRECTORY);
        for (File file : backupDir.listFiles()) {
            if (file.isFile()) {
                file.delete();
                log.info("File {} deleted", file.getName());
            }
        }
        log.info("All files deleted\n" +
                "Writing updated data from products and markets tables");

        FileWriter writer = new FileWriter(DIRECTORY + "products.txt");
        for (Product product : productService.getAllProducts()) {
            writer.write(product.toString() + '\n');
        }
        writer.close();

        writer = new FileWriter(DIRECTORY + "markets.txt");
        for (Market market : marketService.getAllMarkets()) {
            writer.write(market.toString() + '\n');
        }
        writer.close();
        log.info("Finished writing\n" +
                "Scheduled task ended");
    }
}
