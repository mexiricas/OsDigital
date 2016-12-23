/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osdigital.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Alex
 */
public class Utilitarios {

    //Função para remover Caracter da String
    public static String removeCaracteresFromString(String str, String charsRemove, String delimiter) {

        if (charsRemove != null && charsRemove.length() > 0 && str != null) {

            String[] remover = charsRemove.split(delimiter);

            for (int i = 0; i < remover.length; i++) {
                //System.out.println("i: " + i + " ["+ remover[i]+"]");
                if (str.indexOf(remover[i]) != -1) {
                    str = str.replace(remover[i], "");
                }
            }
        }

        return str;
    }



    public static String formatarStr(String texto) {
        String textoFormatado;

        textoFormatado = " '" + texto + "' ";

        return textoFormatado;
    }

    public static String inverteDataStr(String data) {
        //System.out.println("Data Entrada = "+data);
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6, 10);

        String DataFinal = ano + "-" + mes + "-" + dia;
        //System.out.println("Data Invertida = " +DataFinal);

        return DataFinal;
    }

    public static String voltaDataStr(String data) {
        String dia = data.substring(8, 10);
        String mes = data.substring(5, 7);
        String ano = data.substring(0, 4);
        String DataFinal = dia + "/" + mes + "/" + ano;

        return DataFinal;
    }

    public static Date converteParaDate(String Data) {
        DateFormat formatodata = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date DataGuiaformatada3 = formatodata.parse(Data);
            return DataGuiaformatada3;
        } catch (ParseException ex) {
            Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static Date converteParaDateTime(String Data) {
        DateFormat formatodata = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date DataGuiaformatada3 = formatodata.parse(Data);
            return DataGuiaformatada3;
        } catch (ParseException ex) {
            Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static Timestamp converteParaTimestamp(String Data) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date parsedDate = dateFormat.parse(Data);
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
            return timestamp;
        } catch (ParseException ex) {
            Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    public static int contaPontos(String string) {
        String frase = string;

        int cont = 0;
        char letra = '.'; //ocorrencias da string

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == letra) {
                cont++;
            }
        }
        return cont++;
    }

    public static double retirarPontos(String vl) {

        String array[] = vl.split(Pattern.quote("."));
        String valor2 = "";
        for (String valor : array) {
            valor2 = valor2 + valor;
        }
        valor2 = valor2.replace(",", ".");
        double valor = Double.parseDouble(valor2);
        return valor;
    }

    public static int mesInt(String Mes) {
        if (Mes.length() >= 3) {
            Mes = Mes.substring(0, 3);
        }
        if (Mes.equals("Jan")) {
            return 0;
        } else if (Mes.equals("Fev")) {
            return 1;
        } else if (Mes.equals("Mar")) {
            return 2;
        } else if (Mes.equals("Abr")) {
            return 3;
        } else if (Mes.equals("Mai")) {
            return 4;
        } else if (Mes.equals("Jun")) {
            return 5;
        } else if (Mes.equals("Jul")) {
            return 6;
        } else if (Mes.equals("Ago")) {
            return 7;
        } else if (Mes.equals("Set")) {
            return 8;
        } else if (Mes.equals("Out")) {
            return 9;
        } else if (Mes.equals("Nov")) {
            return 10;
        } else if (Mes.equals("Dez")) {
            return 11;
        }
        return 0;
    }

    public static String mesString(int Mes) {
        if (Mes == 1) {
            return "Janeiro";
        } else if (Mes == 2) {
            return "Fevereiro";
        } else if (Mes == 3) {
            return "Marco";
        } else if (Mes == 4) {
            return "Abril";
        } else if (Mes == 5) {
            return "Maio";
        } else if (Mes == 6) {
            return "Junho";
        } else if (Mes == 7) {
            return "Julho";
        } else if (Mes == 8) {
            return "Agosto";
        } else if (Mes == 9) {
            return "Setembro";
        } else if (Mes == 10) {
            return "Outubro";
        } else if (Mes == 11) {
            return "Novembro";
        } else if (Mes == 12) {
            return "Dezezembro";
        }
        return "Erro no mes";
    }

    public static String diaDaData(int primeirodig, int segdigito) {
        String data = "";
        Date dataCal = new Date(System.currentTimeMillis());
        SimpleDateFormat formataData = new SimpleDateFormat("yyyy-MM-dd");
        data = formataData.format(dataCal);
        String ano = data.substring(0, 4);
        String mes = data.substring(5, 7);
        String data2 = ano + "-" + mes + "-" + primeirodig + segdigito;
        return data2;
    }

    public static String formataMoeda(Double Valor) {
        DecimalFormat df = new DecimalFormat("##,###,###,##0.00");
        df.setRoundingMode(RoundingMode.DOWN);
        String formatado = df.format(Valor);
        return formatado;
    }

    public static String formataMoedaSemDown(Double Valor) {
        DecimalFormat df = new DecimalFormat("##,###,###,##0.00");
        String formatado = df.format(Valor);
        return formatado;
    }

    public static double formataDouble2Casas(Double Valor) {
        DecimalFormat df = new DecimalFormat("#,###.00");
        String Valor2 = df.format(Valor);
        return Double.parseDouble(Valor2.replaceAll(",", "."));
    }

    public static String formataMoedaGrafico(Double Valor) {
        DecimalFormat df = new DecimalFormat("##,###,###,##0.00");
        String formatado = df.format(Valor);
        int virgula = formatado.indexOf(",");
        String formatadoNovo = formatado.substring(0, virgula);
        return formatadoNovo;
    }

    public static String formataMoedaGraficoSemPonto(Double Valor) {
        BigDecimal bd = new BigDecimal(Valor).setScale(3, RoundingMode.HALF_EVEN);
        return Double.toString(bd.doubleValue());
    }

    public static String diaSemana(Calendar cal) {
        return new DateFormatSymbols().getWeekdays()[cal.get(Calendar.DAY_OF_WEEK)];
    }

    public static Calendar diaUtil(Calendar cal) {
        int dia = cal.get(Calendar.DAY_OF_WEEK);
        if (dia == 7) {
            cal.add(Calendar.DAY_OF_MONTH, 2);
        } else if (dia == 1) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }
        return cal;
    }

    public static String converteDataParaString(Date Data) {
        try {
            SimpleDateFormat formatar = new SimpleDateFormat("yyyy-MM-dd");
            return formatar.format(Data);
        } catch (Exception Ex) {
            return "Erro na conversão da data";
        }
    }

    public static String converteDataTimeParaString(Date Data) {
        try {
            SimpleDateFormat formatar = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return formatar.format(Data);
        } catch (Exception Ex) {
            return "Erro na conversão da data";
        }
    }

    public static Date converteParaDateElavon(String dataElavon) {
        try {
            String dia = dataElavon.substring(0, 2);
            String mes = dataElavon.substring(2, 4);
            String ano = dataElavon.substring(4);
            SimpleDateFormat formatar = new SimpleDateFormat("yyyy-MM-dd");
            //imprimir a data
            //System.out.println(formatar.format(Data));
            Date dataFormatada = formatar.parse(ano + "-" + mes + "-" + dia);
            return dataFormatada;
        } catch (Exception Ex) {
            return null;
        }
    }

    public static void copy(File origem, File destino) throws IOException {
        Date date = new Date();
        InputStream in = new FileInputStream(origem);
        OutputStream out = new FileOutputStream(destino);
        // Transferindo bytes de entrada para saída
        byte[] buffer = new byte[1024];
        int lenght;
        while ((lenght = in.read(buffer)) > 0) {
            out.write(buffer, 0, lenght);
        }
        in.close();
        out.close();
        Long time = new Date().getTime() - date.getTime();
        System.out.println("Saiu copy" + time);
    }

    public static String buscaDescricaoProdutoElavon(String busca) {
        if (busca.equals("DOMV")) {
            return "VISA CREDITO";
        }
        if (busca.equals("VISA")) {
            return "VISA CREDITO INTERNACIONAL";
        }

        if (busca.equals("VIDE")) {
            return "VISA DEBITO";
        }

        if (busca.equals("DOMM")) {
            return "MASTERCARD CREDITO";
        }

        if (busca.equals("M/C")) {
            return "MASTERCARD CREDITO INTERNACIONAL";
        }

        if (busca.equals("MCDE")) {
            return "MASTERCARD DEBITO";
        }

        if (busca.equals("MSTO")) {
            return "MASTERCARD MAESTRO";
        }

        if (busca.equals("DNCD")) {
            return "DINERS";
        }

        if (busca.equals("DNCB")) {
            return "DINERS INTERNACIONAL";
        }

        if (busca.equals("ADJ")) {
            return "AJUSTES";
        }

        if (busca.equals("BTCH")) {
            return "BATCH HEADERS";
        }

        if (busca.equals("CHGB")) {
            return "CHARGEBACK";
        }

        if (busca.equals("DCC")) {
            return "CONVERSAO DE MOEDAS";
        }

        if (busca.equals("MISC")) {
            return "SERVIÇOS";
        }

        if (busca.equals("UNKN")) {
            return "NÃO INFORMADO";
        }

        return null;
    }

    public static String buscaEmpresa(String empresa) {
        String emp = "";
        if (empresa.equals("BOTICARIO - CANAL LOJAS")) {
            emp = "1";
        } else if (empresa.equals("BOTICARIO - VD")) {
            emp = "2";
        } else if (empresa.equals("QDB")) {
            emp = "3";
        } else if (empresa.equals("LBE")) {
            emp = "4";
        }
        return emp;
    }

    //Parâmetros:  
    /**
     * 1 - Valor a arredondar. 2 - Quantidade de casas depois da vírgula. 3 -
     * Arredondar para cima ou para baixo? Para cima = 0 (ceil) Para baixo = 1
     * ou qualquer outro inteiro (floor)
     *
     */
    public static double arredondar(double valor, int casas, int ceilOrFloor) {
        double arredondado = valor;
        arredondado *= (Math.pow(10, casas));
        if (ceilOrFloor == 0) {
            arredondado = Math.ceil(arredondado);
        } else {
            arredondado = Math.floor(arredondado);
        }
        arredondado /= (Math.pow(10, casas));
        return arredondado;
    }

    public static String format(String pattern, Object value) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /* retorna o valor truncado no numero de decimais especificadas */
    public static double trunc(double value, int decimais) {
        double p = Math.pow(10, decimais);
        return Math.floor(value * p) / p;
    }


    /* Arredonda um valor com o numero de decimais especificado */
    public static double round(double value, int decimais) {
        double p = Math.pow(10, decimais);
        return Math.round(value * p) / p;
    }

}
