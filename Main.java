import functions.*;
import functions.basic.*;
import functions.meta.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("\n--- ЗАДАНИЕ 1: Конструкторы с массивами точек ---");
        testAssignment1();
        
        System.out.println("\n--- ЗАДАНИЕ 2: Интерфейс Function ---");
        testAssignment2();
        
        System.out.println("\n--- ЗАДАНИЕ 3: Аналитические функции ---");
        testAssignment3();
        
        System.out.println("\n--- ЗАДАНИЕ 4: Комбинированные функции ---");
        testAssignment4();
        
        System.out.println("\n--- ЗАДАНИЕ 5: Утилитный класс Functions ---");
        testAssignment5();
        
        System.out.println("\n--- ЗАДАНИЕ 6: Табулирование функций ---");
        testAssignment6();
        
        System.out.println("\n--- ЗАДАНИЕ 7: Ввод-вывод функций ---");
        testAssignment7();
        
        System.out.println("\n--- ЗАДАНИЕ 8: Комплексное тестирование ---");
        testAssignment8();
        
        System.out.println("\n--- ЗАДАНИЕ 9: Сериализация ---");
        testAssignment9();
    }
    
    private static void testAssignment1() {
        try {
            FunctionPoint[] points = {
                new FunctionPoint(0.0, 0.0),
                new FunctionPoint(1.0, 1.0),
                new FunctionPoint(2.0, 4.0)
            };
            
            ArrayTabulatedFunction arrayFunc = new ArrayTabulatedFunction(points);
            System.out.println("ArrayTabulatedFunction создана. Точек: " + arrayFunc.getPointsCount());
            
            LinkedListTabulatedFunction linkedFunc = new LinkedListTabulatedFunction(points);
            System.out.println("LinkedListTabulatedFunction создана. Точек: " + linkedFunc.getPointsCount());
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    
    private static void testAssignment2() {
        try {
            FunctionPoint[] points = {
                new FunctionPoint(0.0, 0.0),
                new FunctionPoint(1.0, 1.0),
                new FunctionPoint(2.0, 4.0)
            };
            
            TabulatedFunction func = new ArrayTabulatedFunction(points);
            System.out.println("Функция реализует интерфейс Function: " + (func instanceof Function));
            System.out.println("Границы: [" + func.getLeftDomainBorder() + ", " + func.getRightDomainBorder() + "]");
            System.out.println("f(1.5) = " + func.getFunctionValue(1.5));
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    
    private static void testAssignment3() {
        try {
            Exp exp = new Exp();
            System.out.println("Экспонента: exp(0) = " + exp.getFunctionValue(0));
            
            Log log2 = new Log(2);
            System.out.println("Логарифм по основанию 2: log2(8) = " + log2.getFunctionValue(8));
            
            Sin sin = new Sin();
            Cos cos = new Cos();
            Tan tan = new Tan();
            System.out.println("Тригонометрические функции:");
            System.out.println("  sin(0) = " + sin.getFunctionValue(0));
            System.out.println("  cos(0) = " + cos.getFunctionValue(0));
            System.out.println("  tan(0) = " + tan.getFunctionValue(0));
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    
    private static void testAssignment4() {
        try {
            Sin sin = new Sin();
            Cos cos = new Cos();
            
            Sum sum = new Sum(sin, cos);
            System.out.println("Сумма sin+cos в точке 0: " + sum.getFunctionValue(0));
            
            Mult mult = new Mult(sin, cos);
            System.out.println("Произведение sin*cos в точке π/4: " + mult.getFunctionValue(Math.PI/4));
            
            Power square = new Power(sin, 2);
            System.out.println("Квадрат синуса в точке π/2: " + square.getFunctionValue(Math.PI/2));
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    
    private static void testAssignment5() {
        try {
            Sin sin = new Sin();
            Cos cos = new Cos();
            
            Function sum = Functions.sum(sin, cos);
            System.out.println("Functions.sum(sin,cos) в 0: " + sum.getFunctionValue(0));
            
            Function mult = Functions.mult(sin, cos);
            System.out.println("Functions.mult(sin,cos) в π/4: " + mult.getFunctionValue(Math.PI/4));
            
            Function power = Functions.power(sin, 2);
            System.out.println("Functions.power(sin,2) в π/2: " + power.getFunctionValue(Math.PI/2));
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    
    private static void testAssignment6() {
        try {
            Sin sin = new Sin();
            TabulatedFunction tabulated = TabulatedFunctions.tabulate(sin, 0, Math.PI, 5);
            
            System.out.println("Табулированный синус с 5 точками:");
            for (int i = 0; i < tabulated.getPointsCount(); i++) {
                FunctionPoint p = tabulated.getPoint(i);
                System.out.printf("  (%.2f, %.4f)%n", p.getX(), p.getY());
            }
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    
    private static void testAssignment7() {
        try {
            Sin sin = new Sin();
            TabulatedFunction func = TabulatedFunctions.tabulate(sin, 0, Math.PI, 5);
            
            // Байтовый ввод-вывод
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            TabulatedFunctions.outputTabulatedFunction(func, byteOut);
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            TabulatedFunction fromBytes = TabulatedFunctions.inputTabulatedFunction(byteIn);
            System.out.println("Байтовый ввод-вывод: успешно");
            
            // Символьный ввод-вывод
            StringWriter stringWriter = new StringWriter();
            TabulatedFunctions.writeTabulatedFunction(func, stringWriter);
            StringReader stringReader = new StringReader(stringWriter.toString());
            TabulatedFunction fromString = TabulatedFunctions.readTabulatedFunction(stringReader);
            System.out.println("Символьный ввод-вывод: успешно");
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    
    private static void testAssignment8() {
        System.out.println("=== Часть 1: Основные функции ===");
        Sin sin = new Sin();
        Cos cos = new Cos();
        
        System.out.println("sin и cos на [0, π] с шагом 0.1:");
        for (double x = 0; x <= Math.PI; x += 0.1) {
            System.out.printf("  x=%.1f: sin=%.6f, cos=%.6f%n", 
                x, sin.getFunctionValue(x), cos.getFunctionValue(x));
        }
        
        System.out.println("\n=== Часть 2: Табулированные аналоги ===");
        TabulatedFunction tabSin = TabulatedFunctions.tabulate(sin, 0, Math.PI, 10);
        TabulatedFunction tabCos = TabulatedFunctions.tabulate(cos, 0, Math.PI, 10);
        
        System.out.println("Сравнение исходных и табулированных:");
        for (double x = 0; x <= Math.PI; x += 0.1) {
            double s1 = sin.getFunctionValue(x);
            double s2 = tabSin.getFunctionValue(x);
            double c1 = cos.getFunctionValue(x);
            double c2 = tabCos.getFunctionValue(x);
            System.out.printf("  x=%.1f: sin: %.6f vs %.6f, cos: %.6f vs %.6f%n",
                x, s1, s2, c1, c2);
        }
        
        System.out.println("\n=== Часть 3: Сумма квадратов ===");
        Function sinSquared = Functions.power(tabSin, 2);
        Function cosSquared = Functions.power(tabCos, 2);
        Function sumSquares = Functions.sum(sinSquared, cosSquared);
        
        System.out.println("sin² + cos² (должно быть ≈ 1):");
        for (double x = 0; x <= Math.PI; x += 0.1) {
            double value = sumSquares.getFunctionValue(x);
            System.out.printf("  x=%.1f: %.6f, отклонение от 1: %.6f%n",
                x, value, Math.abs(value - 1.0));
        }
        
        System.out.println("\n=== Часть 4: Экспонента (текстовый файл) ===");
        try {
            Exp exp = new Exp();
            TabulatedFunction tabExp = TabulatedFunctions.tabulate(exp, 0, 10, 11);
            
            FileWriter writer = new FileWriter("exp_text.txt");
            TabulatedFunctions.writeTabulatedFunction(tabExp, writer);
            writer.close();
            System.out.println("Записано в exp_text.txt");
            
            FileReader reader = new FileReader("exp_text.txt");
            TabulatedFunction readExp = TabulatedFunctions.readTabulatedFunction(reader);
            reader.close();
            
            System.out.println("Сравнение:");
            for (double x = 0; x <= 10; x += 1) {
                double orig = tabExp.getFunctionValue(x);
                double read = readExp.getFunctionValue(x);
                System.out.printf("  x=%.0f: %.6f vs %.6f%n", x, orig, read);
            }
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        
        System.out.println("\n=== Часть 5: Натуральный логарифм (байтовый файл) ===");
        try {
            Log ln = new Log(Math.E);
            TabulatedFunction tabLn = TabulatedFunctions.tabulate(ln, 1, 10, 10);
            
            FileOutputStream fos = new FileOutputStream("ln_binary.bin");
            TabulatedFunctions.outputTabulatedFunction(tabLn, fos);
            fos.close();
            System.out.println("Записано в ln_binary.bin");
            
            FileInputStream fis = new FileInputStream("ln_binary.bin");
            TabulatedFunction readLn = TabulatedFunctions.inputTabulatedFunction(fis);
            fis.close();
            
            System.out.println("Сравнение:");
            for (double x = 1; x <= 10; x += 1) {
                double orig = tabLn.getFunctionValue(x);
                double read = readLn.getFunctionValue(x);
                System.out.printf("  x=%.0f: %.6f vs %.6f%n", x, orig, read);
            }
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    
    private static void testAssignment9() {
        System.out.println("\n=== ЗАДАНИЕ 9: СЕРИАЛИЗАЦИЯ ===");
        
        try {
            // Создаем ln(exp(x)) = x
            Exp exp = new Exp();
            Log ln = new Log(Math.E);
            Function lnOfExp = Functions.composition(ln, exp);
            
            // Табулируем
            TabulatedFunction tabulated = TabulatedFunctions.tabulate(lnOfExp, 0, 10, 11);
            
            System.out.println("ln(exp(x)) = x (теоретически):");
            for (double x = 0; x <= 10; x += 1) {
                System.out.printf("  x=%.0f: ln(exp(x)) = %.6f, ожидается %.6f%n",
                    x, tabulated.getFunctionValue(x), x);
            }
            
            System.out.println("\n--- Serializable сериализация ---");
            // Сериализуем через Serializable
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("function_serializable.ser"));
            oos.writeObject(tabulated);
            oos.close();
            System.out.println("Записано в function_serializable.ser");
            
            // Десериализуем
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("function_serializable.ser"));
            TabulatedFunction deserialized = (TabulatedFunction) ois.readObject();
            ois.close();
            
            System.out.println("Сравнение после Serializable:");
            for (double x = 0; x <= 10; x += 1) {
                double orig = tabulated.getFunctionValue(x);
                double deser = deserialized.getFunctionValue(x);
                System.out.printf("  x=%.0f: %.6f vs %.6f%n", x, orig, deser);
            }
            
            System.out.println("\n--- Externalizable сериализация ---");
            // Для Externalizable нужно создать объект, который реализует Externalizable
            // ArrayTabulatedFunction уже реализует Externalizable
            
            // Сериализуем через Externalizable
            ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("function_externalizable.ser"));
            oos2.writeObject(tabulated);
            oos2.close();
            System.out.println("Записано в function_externalizable.ser");
            
            // Десериализуем
            ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("function_externalizable.ser"));
            TabulatedFunction deserialized2 = (TabulatedFunction) ois2.readObject();
            ois2.close();
            
            System.out.println("Сравнение после Externalizable:");
            for (double x = 0; x <= 10; x += 1) {
                double orig = tabulated.getFunctionValue(x);
                double deser = deserialized2.getFunctionValue(x);
                System.out.printf("  x=%.0f: %.6f vs %.6f%n", x, orig, deser);
            }
            
            // Сравнение размеров файлов
            File serFile = new File("function_serializable.ser");
            File extFile = new File("function_externalizable.ser");
            System.out.println("\nРазмеры файлов:");
            System.out.println("  Serializable: " + serFile.length() + " байт");
            System.out.println("  Externalizable: " + extFile.length() + " байт");
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}