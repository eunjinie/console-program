package com.himedia.mybatis.run;

import com.himedia.mybatis.common.SearchCriteria;
import com.himedia.mybatis.controller.MusicController;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    /* 필요한 테이블 구조를 구상하여 `테이블 생성` 구문, `시퀀스 생성` 구문 등을 수행한다.
    - `조회`, `삽입`, `수정`, `삭제` 기능을 모두 포함하는 프로그램으로 만든다.
    1. 조회 시 `동적 쿼리를 한 번 이상 활용`한다.
    2. 구조는 ****`chap03-crud-lecture-source` 프로젝트의 `section03.remix`를 참조하여
       `Application(실행/콘솔 입출력)` - `Controller` - `Service` - `Dao(Mapper)` 로 정의한다.*/

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MusicController musicController = new MusicController();

        do {
            System.out.println("=======music play list manage======");
            System.out.println("1. 플레이리스트 전체 조회");
            System.out.println("2. 노래 장르로 노래 조회");
            System.out.println("3. 가수 혹은 제목으로 노래 조회");
            System.out.println("4. 주제(기분)로 노래 조회");
            System.out.println("5. 신규 노래 추가");
            System.out.println("6. 노래 정보 수정");
            System.out.println("7. 노래 번호로 노래 삭제");
            System.out.println("9. 종료");
            System.out.print("메뉴 관리 번호 입력 : ");
            int no = sc.nextInt();

            switch(no){
                case 1 : musicController.selectAllMusic(); break;
                case 2 : musicController.selectMusicByGenre(inputGenre()); break;
                case 3 : musicController.searchMusic(inputSearchCriteria()); break;
                case 4 : musicController.searchMusicByMood(inputMood()); break;
                case 5 : musicController.registMusic(inputMusic()); break;
                case 6 : musicController.modifyMusic(inputModifyMenu()); break;
                case 7 : musicController.deleteMusic(inputMusicNo()); break;
                case 9 : return;
                default:
                    System.out.println("잘못 된 메뉴를 선택하셨습니다.");
            }

        } while (true);

    }



    private static Map<String, String> inputGenre() {

        Scanner sc = new Scanner(System.in);
        System.out.print("검색하고싶은 장르를 입력하세요 : ");
        String genre = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("genre", genre);

        return parameter;

    }

    private static SearchCriteria inputSearchCriteria() {

        Scanner sc = new Scanner(System.in);

        System.out.print("검색 기준을 입력해주세요(title or singer) : ");
        String condition = sc.nextLine();
        System.out.print("검색어를 입력해주세요 : ");
        String value = sc.nextLine();

        return new SearchCriteria(condition, value);

    }

    private static Map<String, String> inputMood() {

        Scanner sc = new Scanner(System.in);

        System.out.print("노래 주제를 선택하세요 (신남, 사랑, 이별, 감성) : ");
        String mood = sc.nextLine();

        Map<String, String> criteria = new HashMap<>();
        criteria.put("mood", mood);

        return criteria;
    }


    private static Map<String,String> inputMusic() {
        Scanner sc = new Scanner(System.in);
        System.out.print("노래 제목을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("노래 장르 입력하세요 : ");
        String genre = sc.nextLine();
        System.out.print("가수 이름을 입력하세요 : ");
        String singer = sc.nextLine();
        System.out.print("주제 코드를 입력하세요 : ");
        String themeCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("name", name);
        parameter.put("genre", genre);
        parameter.put("singer", singer);
        parameter.put("themeCode", themeCode);

        return parameter;

    }

    private static Map<String, String> inputModifyMenu() {

        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 노래 코드를 입력하세요 : ");
        String no = sc.nextLine();
        System.out.print("수정할 노래 제목을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("수정할 노래 장르를 입력하세요 : ");
        String genre = sc.nextLine();
        System.out.print("수정할 가수 이름을 입력하세요 : ");
        String singer = sc.nextLine();
        System.out.print("수정할 주제 코드를 입력하세요 : ");
        String themeCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("no", no);
        parameter.put("name", name);
        parameter.put("genre", genre);
        parameter.put("singer", singer);
        parameter.put("themeCode", themeCode);

        return parameter;

    }

    private static Map<String, String> inputMusicNo() {

        Scanner sc = new Scanner(System.in);
        System.out.print("노래 번호를 입력하세요 : ");
        String no = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("no", no);

        return parameter;

    }



}
