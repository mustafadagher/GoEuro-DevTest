package com.goEuro.task.util;

import java.io.FileWriter;
import java.io.IOException;

import com.goEuro.task.bo.Location;
import com.goEuro.task.exception.GoEuroBaseException;
import com.goEuro.task.exception.GoEuroErros;

/**
 * The Class CsvUtils. Contains utils needed to generate a csv file for suggested locations
 *
 * @author mustafa.kamel
 */
public class CsvUtils {

    private static final String DELIMITER = ", ";

    private static final String NEW_LINE = "\n";

    private static final String HEADER = "_id, name, type, latitude, longitude";

    /**
     * Write to CSV file.
     *
     * @param locations the locations
     * @throws GoEuroBaseException if failed to create or write the CSV file
     */
    public static void writeToCsvFile(final String fileName, final Location[] locations) throws GoEuroBaseException {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.append(HEADER.toString());
            fileWriter.append(NEW_LINE);

            for (final Location location : locations) {
                appendLocationEntry(fileWriter, location);
            }

            fileWriter.flush();
            fileWriter.close();
        } catch (final IOException ex) {
            throw GoEuroErros.FILE_CREATION_WRITING_EXCEPTION.buildException(ex);
        }

        System.out.println("file created successfully.");
    }

    private static void appendLocationEntry(final FileWriter fileWriter, final Location location) throws IOException {
        fileWriter.append(location.getId());
        fileWriter.append(DELIMITER);
        fileWriter.append(location.getName());
        fileWriter.append(DELIMITER);
        fileWriter.append(location.getType());
        fileWriter.append(DELIMITER);
        fileWriter.append(location.getGeoPosition().getLatitude());
        fileWriter.append(DELIMITER);
        fileWriter.append(location.getGeoPosition().getLongitude());
        fileWriter.append(NEW_LINE);
    }
}
