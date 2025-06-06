package biovitta.com.clinics.controllers;

import biovitta.com.clinics.services.RelatorioService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("biovitta/api/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    @GetMapping("/consultas")
    public ResponseEntity<byte[]> gerarRelatorioConsultas() {
        try {
            byte[] pdf = relatorioService.gerarRelatorioPDF();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment")
                    .filename("relatorio_consultas.pdf")
                    .build());

            return new ResponseEntity<>(pdf, headers, HttpStatus.OK);

        } catch (JRException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
