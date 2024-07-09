package org.koreait;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MotivationController {

    private static List<Motivation> motivationList = new ArrayList<>();
    private static int lastID;

    public MotivationController() {

        List<Motivation> motivationList = new ArrayList<>();
        lastID = 0;
    }


    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("=====================");

        for(int i = motivationList.size() - 1; i >= 0; i--) {
            Motivation motivation = motivationList.get(i);
            System.out.println(motivation.toString());
        }
    }

    public void add() {
        int id;

        id = ++lastID;
        System.out.print("명언 : ");
        String content = Container.getScanner().nextLine().trim();
        System.out.print("작가 : ");
        String author = Container.getScanner().nextLine().trim();

        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatedNow = dateFormat.format(now);

        Motivation newMotivation = new Motivation(id, formatedNow, content, author);

        motivationList.add(newMotivation);

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }

    public void detail(int option) {
        int id = option;

        Motivation motivation = findMotivation(id);

        if (motivation != null) {

            System.out.println("번호 : " + motivation.getId());
            System.out.println("날짜 : " + motivation.getRegDate());
            System.out.println("작가 : " + motivation.getAuthor());
            System.out.println("내용 : " + motivation.getContent());

        } else {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
        }

    }

    public void edit(int option) {
        int id = option;

        Motivation motivation = findMotivation(id);

        if (motivation != null) {

            System.out.println("명언(기존) : " + motivation.getContent());
            System.out.println("작가(기존) : " + motivation.getAuthor());

            System.out.print("명언 : ");
            String content = Container.getScanner().nextLine().trim();
            System.out.print("작가 : ");
            String author = Container.getScanner().nextLine().trim();

            motivation.setContent(content);
            motivation.setAuthor(author);

            System.out.printf("%d번 명언이 수정되었습니다.\n", id);

        } else {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
        }
    }

    public void delete(int option) {
        int id = option;

        Motivation motivation = findMotivation(id);

        if (motivation != null) {

            motivationList.remove(motivation);
            System.out.printf("%d번 명언이 삭제되었습니다.\n", id);

        } else {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
        }
    }

    private Motivation findMotivation(int id) {
        Motivation foundMotivation = null;

        for (Motivation motivation : motivationList) {
            if (motivation.getId() == id) {
                foundMotivation = motivation;
                return foundMotivation;
            }
        }
        return foundMotivation;
    }
}
