
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class DictionaryCommandLine extends Dictionary{
    static DictionaryManagement manage = new DictionaryManagement();
    static DictionaryCommandLine show = new DictionaryCommandLine();

    public void showAllWords() {
        System.out.printf("%-8s|%-30s|%s\n", "No", "English", "Tieng Viet");

        for (int i = 0; i < list.size(); ++i) {
            String no = String.valueOf(i + 1);
            Word w = list.get(i);
            String target = w.getWord_target();
            String explain = w.getWord_explain();
            System.out.printf("%-8s|%-30s|%s\n", no, target, explain);
        }
    }

    public void dictionaryBasic() {
        DictionaryManagement manager = new DictionaryManagement();
        DictionaryCommandLine show = new DictionaryCommandLine();
        manager.insertFromCommandline();
        show.showAllWords();
    }


    public void dictionaryAdvanced() throws IOException {
        int opt = -1;
        Scanner input = new Scanner(System.in);
        do {
                System.out.println("1. Tra từ");
                System.out.println("2. Thêm từ vào danh sách");
                System.out.println("3. Xóa từ khỏi danh sách");
                System.out.println("4. Sửa từ trong danh sách");
                System.out.println("5. Hiển thị tất cả các từ");
                System.out.println("6. Xuất ra file");
                System.out.println("Nhập lựa chọn: ");
                try{
                opt = input.nextInt();}
                catch (InputMismatchException e) {
                }
                input.nextLine();
                switch (opt) {
                    case 1: {
                        list.clear();
                        manage.insertFromFile();

                        show.showAllWords();
                        manage.dictionaryLookup();
                        //   order.dictionarySearcher();
                        System.out.print("nhan phim enter de tiep tuc... ");
                        input.nextLine();
                        continue;
                    }
                    case 2: {
                        System.out.println("Nhập từ cần thêm: ");
                        String t = input.nextLine();
                        System.out.println("Nhập nghĩa của từ cần thêm: ");
                        String e = input.nextLine();
                        manage.addNewWord(t,e);
                        show.showAllWords();

                        System.out.print("nhan phim enter de tiep tuc... ");
                        input.nextLine();
                        continue;
                    }
                  /*  case 3: {


                        list.clear();
                        manage.insertFromFile();
                        System.out.print("nhan phim enter de tiep tuc... ");
                        input.nextLine();
                        continue;
                    }
                    case 4: {
                        list.clear();
                        manage.insertFromFile();
                        System.out.print("nhan phim enter de tiep tuc... ");
                        input.nextLine();
                        continue;
                    } */

                    case 5: {
                        list.clear();
                        manage.insertFromFile();

                        show.showAllWords();
                        System.out.print("nhan phim enter de tiep tuc... ");
                        input.nextLine();
                        continue;
                    }
                    default: {
                        System.out.println("yeu cau ban tra khong hop le");
                        System.out.print("nhan phim enter de tiep tuc... ");
                        input.nextLine();
                        continue;
                    }
                }
            }while (opt != 0);
        }


}
