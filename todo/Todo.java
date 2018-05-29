package todo;

public class Todo{
    private String content;
    private int importance=5;
    
    public Todo(String content,int importance){
        this.content = content;
        this.setImportance(importance);
    }
    
    public String showInfo(){
        return String.format("%s,%d",this.content,this.importance);
    }
    
    public void setImportance(int importance){
        if(importance > 5){
            this.importance = 5;
        }else if(importance < 1){
            this.importance = 1;
        }else{
            this.importance = importance;
        }
    }
}