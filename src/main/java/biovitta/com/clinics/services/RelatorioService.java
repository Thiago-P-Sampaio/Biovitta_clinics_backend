package biovitta.com.clinics.services;

import biovitta.com.clinics.DTOs.ConsultaRelatorioDTO;
import biovitta.com.clinics.entities.Consulta;
import biovitta.com.clinics.repositories.ConsultaRepositorio;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RelatorioService {

    @Autowired
    private ConsultaRepositorio consultaRepositorio;

    public byte[] gerarRelatorioPDF() throws JRException {

        List<Consulta> consultas = consultaRepositorio.findAll();

        List<ConsultaRelatorioDTO> dados = consultas.stream()
                .map(ConsultaRelatorioDTO::new)
                .collect(Collectors.toList());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dados);

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("dataGeracao", new Date());



        JasperReport jasperReport = JasperCompileManager.compileReport(
                getClass().getResourceAsStream("/relatorio/relatorio_consultas.jrxml"));


        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource);


        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

}
