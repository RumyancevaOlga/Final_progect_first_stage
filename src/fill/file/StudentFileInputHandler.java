package fill.file;

import collection.CustomArrayList;
import fill.InputHandler;
import model.Student;

public class StudentFileInputHandler implements InputHandler<Student> {

    private FileReaderCsv fileReaderCsv;
    private int count = 1;

    public FileReaderCsv getFileReaderCsv() {
        return fileReaderCsv;
    }

    public void setFileReaderCsv(FileReaderCsv fileReaderCsv) {
        this.fileReaderCsv = fileReaderCsv;
    }

    @Override
    public Student input() {

        CustomArrayList<String[]> data = fileReaderCsv.getData();

        try {
            String[] line = data.get(count);
            Student student = new Student.Builder()
                    .groupNumber(Integer.parseInt(line[0]))
                    .averageGrade(Double.parseDouble(line[1]))
                    .recordBookNumber(Integer.parseInt(line[2]))
                    .build();
            count ++;
            return student;
        } catch (IllegalArgumentException e) {
            System.out.println("Данные в файле не соответствуют необходимым параметрам");
        }
        return null;
    }
}
