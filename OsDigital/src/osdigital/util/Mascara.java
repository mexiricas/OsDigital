package osdigital.util;

import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mascara {

    public Mascara() {
    }

    public MaskFormatter maskData(JFormattedTextField textfield) throws ParseException {
        MaskFormatter mask = null;
        mask = new MaskFormatter("##/##/####");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.setPlaceholderCharacter('_');
        mask.install(textfield);
        return mask;
    }

    public MaskFormatter maskCep(JFormattedTextField textfield) throws ParseException {
        MaskFormatter mask = null;
        mask = new MaskFormatter("##.###-###");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.setPlaceholderCharacter('_');
        mask.install(textfield);
        return mask;
    }

    public MaskFormatter maskCPF(JFormattedTextField textfield) throws ParseException {
        MaskFormatter mask = null;
        mask = new MaskFormatter("###.###.###-##");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.setPlaceholderCharacter('_');
        mask.install(textfield);
        return mask;
    }

    public MaskFormatter maskTel(JFormattedTextField textfield) throws ParseException {
        MaskFormatter mask = null;
        mask = new MaskFormatter("(##)####-#####");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.setPlaceholderCharacter('_');
        mask.install(textfield);
        return mask;
    }

    public Double moneyToDouble(String numero) {
        String s = numero.replace("R$", "");
        s = s.replace(".", "");
        s = s.replace(",", ".");
        //      double d = Double.parseDouble(numero.replaceAll("R$", "").replaceAll(",", "."));

        return Double.parseDouble(s);

    }

    public String dobleToMoney(Double d) {

        return NumberFormat.getCurrencyInstance().format(d);

    }

    public static boolean isEmailValid(String email) {
        if ((email == null) || (email.trim().length() == 0)) {
            return false;
        }
        String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
