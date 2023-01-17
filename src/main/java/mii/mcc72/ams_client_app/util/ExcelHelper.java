package mii.mcc72.ams_client_app.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mii.mcc72.ams_client_app.models.dto.RegistrationDTO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;

import mii.mcc72.ams_client_app.models.Employee;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "first_name", "last_name", "phone_number", "email", "username", "password",
            "is_enabled" };
    static String SHEET = "Tutorials";

    // excel format
    public static boolean hasExcelFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<RegistrationDTO> excelToUsers(InputStream is) {
        try {
            Workbook workbook = WorkbookFactory.create(is);

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            List<RegistrationDTO> registrationDTOS = new ArrayList<RegistrationDTO>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                org.apache.poi.ss.usermodel.Row currentRow = rows.next();
                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                RegistrationDTO registrationDTO = new RegistrationDTO();
                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    DataFormatter df = new DataFormatter();
                    switch (cellIdx) {

                        case 0:
                            break;
                        case 1:
                            registrationDTO.setFirstName(df.formatCellValue(currentCell));
                            break;
                        case 2:
                            registrationDTO.setLastName(df.formatCellValue(currentCell));
                            break;

                        case 3:
                            registrationDTO.setPhoneNumber(df.formatCellValue(currentCell));
                            break;
                        case 4:
                            registrationDTO.setEmail(df.formatCellValue(currentCell));
                            break;
                        case 5:
                            registrationDTO.setUsername(df.formatCellValue(currentCell));
                            break;
                        case 6:
                            registrationDTO.setPassword(df.formatCellValue(currentCell));
                            break;
                        default:
                            break;
                    }
                    cellIdx++;
                }
                registrationDTOS.add(registrationDTO);
            }
            workbook.close();
            return registrationDTOS;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
