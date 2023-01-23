package com.ccee.teste.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ccee.teste.model.Agente;
import com.ccee.teste.model.request.AgentesRequest;
import com.ccee.teste.repository.AgenteRepository;

@Service
public class UploadService {

    @Autowired
    private AgenteService agenteService;

    public void uploadFile(MultipartFile file) {

        try {
            //só pra aparecer o loadnofront
            TimeUnit.SECONDS.sleep(2);

            JAXBContext jaxbContext = JAXBContext.newInstance(AgentesRequest.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            AgentesRequest agentes = (AgentesRequest) jaxbUnmarshaller.unmarshal(uploadFileHandler(file));
     
           agentes.getAgente().stream().forEach(a -> System.out.println("cod agente: "+a.getCodigo()));

            
           this.agenteService.salvar(agentes.toAgentes());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
        File convFile = new File(System.getProperty("java.io.tmpdir"));
        multipart.transferTo(convFile);
        return convFile;
    }

    public File uploadFileHandler(MultipartFile file) throws IOException {

        byte[] bytes = file.getBytes();

        // Creating the directory to store file
        String rootPath = System.getProperty("catalina.home");
        File dir = new File(rootPath + File.separator + "tmpFiles");
        if (!dir.exists())
            dir.mkdirs();

        // Create the file on server
        File serverFile = new File(dir.getAbsolutePath()
                + File.separator + "teste");
        BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(serverFile));
        stream.write(bytes);
        stream.close();

        return serverFile;

    }
}
