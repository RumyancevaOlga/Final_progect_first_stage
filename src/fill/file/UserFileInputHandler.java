package fill.file;

import collection.CustomArrayList;
import fill.InputHandler;
import model.User;

public class UserFileInputHandler implements InputHandler<User> {

    private FileReaderCsv fileReaderCsv;
    private int count = 1;

    public FileReaderCsv getFileReaderCsv() {
        return fileReaderCsv;
    }

    public void setFileReaderCsv(FileReaderCsv fileReaderCsv) {
        this.fileReaderCsv = fileReaderCsv;
    }

    @Override
    public User input() {

        CustomArrayList<String[]> data = fileReaderCsv.getData();

        try {
            String[] line = data.get(count);
            User user = new User.Builder()
                    .name(line[0])
                    .password(line[1])
                    .email(line[2])
                    .build();
            count ++;
            return user;
        } catch (IllegalArgumentException e) {
            System.out.println("Данные в файле не соответствуют необходимым параметрам");
        }
        return null;
    }
}
