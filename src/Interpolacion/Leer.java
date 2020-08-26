package Interpolacion;

import java.io.*;
class Leer
{
    /*LEER CADENAS DE CARACTERES*/
    public static String dato()
    {
        String aux = "";
        try
        {
            InputStreamReader isr = new InputStreamReader (System.in);
            BufferedReader br = new BufferedReader (isr);
            aux = br.readLine ();
        }
        catch (IOException e)
        {
            System.out.println ("ERROR FATAL" + e.getMessage ());
        }
        return aux;
    } 

    /*LEER ENTEROS CORTOS*/
    public static short datoShort ()
    {
        String aux = "";
        boolean b = true;
        while (b)
        {
            try
            {
                aux = dato ();
                b = false;
                return (Short.parseShort (aux));
            }
            catch (NumberFormatException e)
            {
                System.out.println ("DEBE INGRESAR UN NUMERO ENTERO");
                b = true;
            }
        }
        return (Short.MIN_VALUE);
    }

  /*leer datos de tipo REAL float*/
    public static float datoFloat ()
    {
        boolean b = true;
        while (b)
        {
            try
            {
                Float A = new Float (dato());
                b = false;
                return A.floatValue ();
            }
            catch (NumberFormatException e)
            {
                System.out.println ("Debe ingresar un numero real");
                b = true;
            }
        }
        return Float.NaN;
    }

    /*leer datos de tipo CARACTER*/
    public static char datoChar ()
    {
        char A;
        try
        {
            A = dato().charAt (0);
            return A;
        }
        catch (Exception e)
        {
            System.out.println ("Debe ingresar un caracter");
            return '\0';
        }
    }

/*leer datos de tipo real double*/
    public static double datoDouble ()
    {
        boolean b = true;
        while (b)
        {
            try
            {
                Double A = new Double (dato());
                b = false;
                return A.doubleValue ();
            }
            catch (NumberFormatException e)
            {
                System.out.println ("Debe ingresar un numero real largo");
                b = true;
            }
        }
        return Double.NaN;
    }

    /*LEER ENTEROS*/
    public static int datoInt ()
    {
        String aux = "";
        boolean b = true;
        while (b)
        {
            try
            {
                aux = dato();
                b = false;
                return (Integer.parseInt (aux));
            }
            catch (NumberFormatException e)
            {
                System.out.println ("DEBE INGRESAR UN NUMERO ENTERO");
                b = true;
            }
        }
        return (Integer.MIN_VALUE);
    }

    /*LEER ENTEROS LARGOS*/
    public static long datoLong ()
    {
        String aux = "";
        boolean b = true;
        while (b)
        {
            try
            {
                aux = dato();
                b = false;
                return (Long.parseLong (aux));
            }
            catch (NumberFormatException e)
            {
              System.out.println ("DEBE INGRESAR UN NUMERO ENTERO LARGO");
                b = true;
            }
        }
        return (Long.MIN_VALUE);
    }
} //fin leer

