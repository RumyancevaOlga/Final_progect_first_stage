package fill.file;

import collection.CustomArrayList;
import fill.InputHandler;
import model.Bus;

public class BusFileInputHandler implements InputHandler<Bus> {

    private FileReaderCsv fileReaderCsv;
    private int count = 1;

    public FileReaderCsv getFileReaderCsv() {
        return fileReaderCsv;
    }

    public void setFileReaderCsv(FileReaderCsv fileReaderCsv) {
        this.fileReaderCsv = fileReaderCsv;
    }

    @Override
    public Bus input() {

        CustomArrayList<String[]> data = fileReaderCsv.getData();

        try {
            String[] line = data.get(count);
            Bus bus = new Bus.Builder()
                        .number(Integer.parseInt(line[0]))
                        .model(line[1])
                        .mileage(Double.parseDouble(line[2]))
                        .build();
            count ++;
            return bus;
        } catch (IllegalArgumentException e) {
            System.out.println("Данные в файле не соответствуют необходимым параметрам");
        }
        return null;
    }
}
