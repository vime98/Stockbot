package com.code.stockbot.service;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {
    public static final String HISTORIAL_CSV = "historial.csv";

    public String consultarPrecio(String stockCode) {
        String url = "https://stooq.com/q/l/?s=" + stockCode + ".us&f=sd2t2ohlcv&h&e=csv";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        if (response != null) {
            String[] lines = response.split("\n");
            if (lines.length > 1) {
                String[] row = lines[1].split(",");
                if (row.length > 1) {
                    guardarPrecioEnHistorial(stockCode, row[6]);
                    return row[6];  // Posicion donde se encuentra el valor
                }
            }
        }

        return "No se pudo obtener el precio de: " + stockCode;

    }

    private void guardarPrecioEnHistorial(String stockCode, String price) {
        try (FileWriter writer = new FileWriter(HISTORIAL_CSV, true)) {
            writer.append(stockCode);
            writer.append(",");
            writer.append(price);
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> obtenerHistorial() {
        List<String[]> historial = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(HISTORIAL_CSV))) {
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                historial.add(line);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return historial;
    }
}
