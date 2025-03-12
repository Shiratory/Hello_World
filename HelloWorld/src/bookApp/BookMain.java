package bookApp;

import java.util.Scanner;

public class BookMain {
	public static Scanner scn = new Scanner(System.in);

    private static Book[] bookStore = new Book[100];  // Make this static to access it in init()

    /* 함수는 main 밖에다가 작성하기 */
    
    //이미 존재하는 제목은 입룍불가
    
    public static void addBook() {
    	System.out.print("제목을 입력하세요: ");
        String title = scn.nextLine();
        
        System.out.print("저자를 입력하세요: ");
        String author = scn.nextLine();
        System.out.print("출판사를 입력하세요: ");
        String company = scn.nextLine();
        System.out.print("가격을 입력하세요: ");
        int price = Integer.parseInt(scn.nextLine());
        Book book = new Book();
        book.setBook(title, author, company, price);
        for(int i = 0; i < bookStore.length; i++) {
            if(bookStore[i] == null) {
                bookStore[i] = book;
                System.out.println("등록됨");
                break;
            }
            if(bookStore[i] == book) {
            	System.out.println("이미 등록된 책입니다");
            	break;
            }
        }
    }
    
    public static void editBook() {
        System.out.print("수정할 책제목을 입력하세요: ");
        String overwrite_name = scn.nextLine();
        System.out.print("수정할 금액을 입력하세요: ");
        int overwrite_price = Integer.parseInt(scn.nextLine());
        for(int i = 0; i < bookStore.length; i++) {
            if(bookStore[i] != null && overwrite_name.equals(bookStore[i].getTitle())) {
                bookStore[i].setPrice(overwrite_price);
                System.out.println("수정됨");
                break;
            }
        }
    }
    
    public static void delBook() {
    	System.out.print("제목을 입력하세요: ");
        String title = scn.nextLine();
        boolean isExist = false;
        for(int i = 0; i < bookStore.length; i++) {
            if(bookStore[i] != null && bookStore[i].getTitle().equals(title)) {
                bookStore[i] = null;
                System.out.println("삭제됨");
                isExist = true;
                break;
            }
        }
    }
    
    public static void listBook() {
    	  int seqNo = 1;
    	  System.out.println("제목    출판사    저자   가격");
          System.out.println("=============================");
          for (Book booklist : bookStore) {
              if(booklist != null) {
                  System.out.println(seqNo++ + " " + booklist.showList());
              }
         }
    }
    
    public static void main(String[] args) {
        boolean run = true;
     
        init();

        while(run) {
            System.out.println("1. 도서등록 2. 수정 3. 삭제 4. 목록 9. 종료");
            System.out.print("선택>> ");
            
            int menu = Integer.parseInt(scn.nextLine());
            boolean isExist;
            switch(menu) {
            
            case 1:// 등록
            	addBook();
                break;
            case 2: // 수정
            	editBook();
                break;
            case 3: // 삭제
                delBook();
                break;
            case 4: // 목록
            	listBook();
                break;
            case 9: // 종료
                run = false;
                break;
            default:
                System.out.println("메뉴를 다시 선택하세요");
            }
        }
        System.out.println("end of prog");
    }

    public static void init() {
        bookStore[0] = new Book("이것이자바다", "신용권", "한빛출", 20000);
        bookStore[1] = new Book("스크립트기초", "박기초", "우리출", 26000);
        bookStore[2] = new Book("HTML,CSS", "김하늘", "가람출", 18000);
    }
}
