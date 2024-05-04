package com.infinityIterators.view.interaction;

import java.util.*;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * 사용자로부터 정수를 입력받는 메소드 <br>
     * <blockquot><pre>{@code
     * requestInt("정수를 입력하세요", false);
     * }</pre></blockquot>
     * @param message 입력을 요청하는 메시지
     * @param allowBlank 빈 문자열 입력 허용 여부
     * @return 입력받은 정수 {@link Integer}
     * @throws Exception 빈 문자열 입력 시
     */
    public static Integer requestInt(String message, boolean allowBlank) throws Exception {
        requestString(message, allowBlank);

        return Integer.parseInt(message);   // throws NumberFormatException
    }

    /**
     * 사용자로부터 문자열을 입력받는 메소드<br>
     * <blockquot><pre>{@code
     * requestString("문자열을 입력하세요", false);
     * }</pre></blockquot>
     * @param message 입력을 요청하는 메시지
     * @param allowBlank 빈 문자열 입력 허용 여부
     * @return 입력받은 문자열 {@link String}
     * @throws Exception 빈 문자열 입력 시
     */
    public static String requestString(String message, boolean allowBlank) throws Exception {
        Console.print(message + ": ", DisplayType.NORMAL, false);
        String input = scanner.nextLine();

        if(input.isEmpty()) {
            if(allowBlank) return null;
            throw new Exception("입력값이 없습니다.");
        }
        return input;
    }

    /**
     * 사용자로부터 문자를 입력받는 메소드<br>
     * <blockquot><pre>{@code
     * requestChar("문자를 입력하세요", false);
     * }</pre></blockquot>
     * @param message 입력을 요청하는 메시지
     * @param allowBlank 빈 문자열 입력 허용 여부
     * @return 입력받은 문자 {@link Character}
     * @throws Exception 빈 문자열 입력 시
     */
    public static Character requestChar(String message, boolean allowBlank) throws Exception {
        requestString(message, allowBlank);
        return message.charAt(0);
    }

    /**
     * 사용자로부터 숨겨진 문자열을 입력받는 메소드<br>
     * <blockquot><pre>{@code
     * requestHiddenInput("비밀번호를 입력하세요", false);
     * }</pre></blockquot>
     * @param message 입력을 요청하는 메시지
     * @param allowBlank 빈 문자열 입력 허용 여부
     * @return 입력받은 문자열 {@link String}
     * @throws Exception 빈 문자열 입력 시
     */
    public static String requestHiddenInput(String message, boolean allowBlank) throws Exception {
        java.io.Console console = System.console();
        if(console == null) throw new RuntimeException("Console not available");

        Console.print(message + ": ", DisplayType.NORMAL, false);
        char[] password = console.readPassword();

        if(password.length == 0) {
            if(allowBlank) return null;
            throw new Exception("입력값이 없습니다.");
        }

        return new String(password);
    }
}
