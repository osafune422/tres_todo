import todo.Todo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    private static Scanner scanNo = new Scanner(System.in); //数値用Scanner
    private static Scanner scanLine = new Scanner(System.in); //文字列用Scanner
    
    public static void main(String[] args){
        ArrayList<Todo> list = new ArrayList<>();
        System.out.println("*****TodoApp*****");
        while(true){
            showList(list);
            System.out.println("-----数値を入力してください-----");
            System.out.print("1:登録　2:重要度の変更　3:削除　4:Todo一覧　8:アプリの終了>>");
            int select = scanNo.nextInt();
            switch(select){
                case 1:
                    newTodo(list);
                    break;
                case 2:
                    updateTodo(list);
                    break;
                case 3:
                    deleteTodo(list);
                    break;
                case 4:
                    System.out.println("Todo一覧");
                    break;
                case 8:
                    System.out.println("アプリケーションを終了します");
                    scanNo.close();
                    scanLine.close();
                    return;
                default:
                    System.out.println("1~4を入力してください");
                    break;
            }
        }
    }
    
    private static void showList(ArrayList<Todo> list){
        if(list.size()<=0){
            System.out.println("Todoは1件もありません");
            return;
        }
        for(int i=0;i<list.size();i++){
            System.out.printf("No.%d:%s%n",i,list.get(i).showInfo());
        }
    }
    
    private static void newTodo(ArrayList<Todo> list){
        System.out.println("1：新規ToDoを作成します");
        System.out.print("ToDo内容を入力してください>>");
        String content = scanLine.nextLine();
        System.out.print("重要度を1~5で入力してください>>");
        int importance = scanNo.nextInt();
        while(importance < 1 || 5 < importance){
            System.out.print("1～5のうちのどれかで入力してください>>");
            importance = scanNo.nextInt();
        }
        Todo atodo = new Todo(content,importance);
        list.add(atodo);
        System.out.println("ToDoを1件追加しました");
    }
    
    private static void updateTodo(ArrayList<Todo> list){
        System.out.println("2：重要度を変更します");
        System.out.print("どのToDoの重要度を変更しますか>>No.");
        int id = scanNo.nextInt();
        System.out.print("重要度を再設定してください>>");
        int importance = scanNo.nextInt();
        while(importance < 1 || 5 < importance){
            System.out.print("1～5のうちのどれかで入力してください>>");
            importance = scanNo.nextInt();
        }
        list.get(id).setImportance(importance);
        System.out.printf("No.%dの重要度を変更しました%n",id);
    }
    
    private static void deleteTodo(ArrayList<Todo> list){
        System.out.println("3：Todoを削除します");
        System.out.print("どのToDoを削除しますか>>No.");
        int id = scanNo.nextInt();
        System.out.printf("No.%d:%s%n",id,list.get(id).showInfo());
        System.out.println("上記のToDoを本当に削除しますか");
        System.out.print("1.はい　2.いいえ>>");
        int yesno = scanNo.nextInt();
        while(yesno != 1 && yesno != 2){
            System.out.print("1か2を入力してください　1.はい　2.いいえ>>");
            yesno = scanNo.nextInt();
        }
        if(yesno == 1){
            list.remove(id);
            System.out.println("削除しました");
        }else{
            System.out.printf("No.%dを削除しませんでしたした%n",id);
        }
    }
    
}