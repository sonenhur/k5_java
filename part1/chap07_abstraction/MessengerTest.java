package part1.chap07_abstraction;

public class MessengerTest {
    public static void main(String[] args) {

        IPhoneMessenger iphone = new IPhoneMessenger();
        GalaxyMessenger galaxy = new GalaxyMessenger();

        System.out.println("메신저 최소 문자 크기" + Messenger.MIN_SIZE);
        System.out.println("메신저 최대 문자 크기" + Messenger.MAX_SIZE);

        System.out.println();

        iphone.setLogion(true);
        iphone.getMessage();
        iphone.setMessage("hello");
        iphone.clearMessage();
        iphone.draw_textBox();
        iphone.draw_submitButton();

        System.out.println();

        galaxy.setLogion(true);
        galaxy.getMessage();
        galaxy.setMessage("hi");
        galaxy.changeKeyboard();
        galaxy.fileDownload();
        galaxy.fileUpload();
    }
}
