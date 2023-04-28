package com.nutouchh.pract24.service;

import com.nutouchh.pract24.model.Market;
import com.nutouchh.pract24.model.Product;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class SchedulerServiceTest {
    private SchedulerService schedulerService;
    @Mock
    private ProductService productService;
    @Mock
    private MarketService marketService;

    @BeforeEach
    public void setUp() throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        schedulerService = new SchedulerService(productService, marketService);
    }

    @Test
    public void testMakeBackup() throws Exception {
        SchedulerService schedulerService = Mockito.spy(new SchedulerService(productService, marketService));
        Field directoryField = SchedulerService.class.getDeclaredField("DIRECTORY");
        directoryField.setAccessible(true);
        directoryField.set(schedulerService, "src/backups/");

        File backupDirectory = new File("src/backups/");
        FileUtils.deleteDirectory(backupDirectory);
        backupDirectory.mkdirs();

        Product product = new Product();
        Market market = new Market();
        Mockito.when(productService.getAllProducts()).thenReturn(Collections.singletonList(product));
        Mockito.when(marketService.getAllMarkets()).thenReturn(Collections.singletonList(market));

        schedulerService.makeBackup();

        File[] backupFiles = backupDirectory.listFiles();
        assertEquals(2, backupFiles.length);
    }
}