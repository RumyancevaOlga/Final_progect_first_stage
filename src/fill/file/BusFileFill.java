package fill.file;

import collection.CustomArrayList;
import fill.file.FileReaderCsv;
import fill.InputHandler;
import model.Bus;

public class BusFileFill implements InputHandler {

    private FileReaderCsv fileReaderCsv;
    private CustomArrayList<Bus> buses;

    public FileReaderCsv getFileReaderCsv() {
        return fileReaderCsv;
    }

    public void setFileReaderCsv(FileReaderCsv fileReaderCsv) {
        this.fileReaderCsv = fileReaderCsv;
    }

    @Override
    public CustomArrayList<Bus> input() {

        CustomArrayList<String[]> data = fileReaderCsv.getData();
        buses = new CustomArrayList();

        try {
            for (int i = 0; i < data.size(); i++) {
                String[] line = data.get(i);
                buses.add(new Bus.Builder().number(Integer.parseInt(line[0])).model(line[1]).mileage(Double.parseDouble(line[2])).build());
            }
            return buses;
        } catch (IllegalArgumentException e) {
            System.out.println("Данные в файле не соответствуют необходимым параметрам");
        }
        return null;
    }
}
