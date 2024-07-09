package org.koreait;

public class App {
    public void run() {

        System.out.println("== 명언 앱 실행 ==");

        int sys_status = 0;

        MotivationController motivationController = new MotivationController();

//        명령어 ) 목록
//        명령어 ) 등록
//        명령어 ) 수정?id=3
//        명령어 ) 상세보기?id=3
//        명령어 ) 삭제?id=3
//        명령어 ) 종료

        while (sys_status == 0) {
            System.out.print("명령어 ) ");
            String cmd = Container.getScanner().nextLine().trim();
            String option = null;

            if (cmd.equals("종료")) {
                sys_status = -1;
                continue;
            }

            String[] options = cmd.split("\\?", 2);
            if (options.length > 1) {
                String[] opts = options[1].split("=", 2);
                if (opts.length > 1) {
                    option = opts[1];
//                    System.out.println("option = " + option);
                }
            }

            if (cmd.equals("목록")) {
                motivationController.list();

            } else if (cmd.equals("등록")) {
                motivationController.add();

            } else if (cmd.startsWith("상세보기")) {
                if (option != null)
                    motivationController.detail(Integer.parseInt(option));
                else {
                    System.out.println("올바르지 않은 접근입니다.");
                }
            } else if (cmd.startsWith("수정")) {

                if (option != null)
                    motivationController.edit(Integer.parseInt(option));
                else {
                    System.out.println("올바르지 않은 접근입니다.");
                }
            } else if (cmd.startsWith("삭제")) {

                if (option != null)
                    motivationController.delete(Integer.parseInt(option));
                else {
                    System.out.println("올바르지 않은 접근입니다.");
                }
            } else {
                System.out.println("올바르지 않은 접근입니다.");
            }

        }

    }
}
