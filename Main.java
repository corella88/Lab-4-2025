import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("ПОЛНЫЙ ТЕСТ ВСЕХ ЗАДАНИЙ");
        System.out.println("=================================================\n");
        
        testAssignment1();
        testAssignment2();
        testAssignment3();
        testAssignment4();
        testAssignment5();
        testAssignment6();
        testAssignment7();
        testAssignment8();
        testAssignment9();
    }
    
    private static void testAssignment1() {
        System.out.println("=== ЗАДАНИЕ 1: КОНСТРУКТОРЫ С МАССИВАМИ ТОЧЕК ===");
        
        try {
            functions.FunctionPoint[] points = {
                new functions.FunctionPoint(0.0, 0.0),
                new functions.FunctionPoint(1.0, 1.0), 
                new functions.FunctionPoint(2.0, 4.0),
                new functions.FunctionPoint(3.0, 9.0)
            };
            
            System.out.println("1. ArrayTabulatedFunction:");
            functions.TabulatedFunction arrayFunc = new functions.ArrayTabulatedFunction(points);
            System.out.println("   Успешно создана! Точек: " + arrayFunc.getPointsCount());
            
            System.out.println("2. LinkedListTabulatedFunction:");
            functions.TabulatedFunction linkedFunc = new functions.LinkedListTabulatedFunction(points);
            System.out.println("   Успешно создана! Точек: " + linkedFunc.getPointsCount());
            
            System.out.println("3. Тест ошибок:");
            
            try {
                functions.FunctionPoint[] fewPoints = {new functions.FunctionPoint(0, 0)};
                functions.TabulatedFunction badFunc = new functions.ArrayTabulatedFunction(fewPoints);
            } catch (IllegalArgumentException e) {
                System.out.println("   Мало точек: " + e.getMessage());
            }
            
            try {
                functions.FunctionPoint[] unorderedPoints = {
                    new functions.FunctionPoint(0, 0),
                    new functions.FunctionPoint(2, 4), 
                    new functions.FunctionPoint(1, 1)
                };
                functions.TabulatedFunction badFunc = new functions.LinkedListTabulatedFunction(unorderedPoints);
            } catch (IllegalArgumentException e) {
                System.out.println("   Неупорядоченные точки: " + e.getMessage());
            }
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testAssignment2() {
        System.out.println("=== ЗАДАНИЕ 2: ИНТЕРФЕЙС FUNCTION И НАСЛЕДОВАНИЕ ===");
        
        try {
            functions.FunctionPoint[] points = {
                new functions.FunctionPoint(0.0, 0.0),
                new functions.FunctionPoint(1.0, 1.0), 
                new functions.FunctionPoint(2.0, 4.0)
            };
            
            functions.TabulatedFunction arrayFunc = new functions.ArrayTabulatedFunction(points);
            functions.TabulatedFunction linkedFunc = new functions.LinkedListTabulatedFunction(points);
            
            System.out.println("1. Проверка наследования:");
            System.out.println("   ArrayTabulatedFunction instanceof Function: " + (arrayFunc instanceof functions.Function));
            System.out.println("   LinkedListTabulatedFunction instanceof Function: " + (linkedFunc instanceof functions.Function));
            
            System.out.println("2. Тест методов интерфейса Function:");
            System.out.println("   Array - границы: [" + arrayFunc.getLeftDomainBorder() + ", " + arrayFunc.getRightDomainBorder() + "]");
            System.out.println("   Array - f(1.5) = " + arrayFunc.getFunctionValue(1.5));
            
            System.out.println("   LinkedList - границы: [" + linkedFunc.getLeftDomainBorder() + ", " + linkedFunc.getRightDomainBorder() + "]");
            System.out.println("   LinkedList - f(1.5) = " + linkedFunc.getFunctionValue(1.5));
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testAssignment3() {
        System.out.println("=== ЗАДАНИЕ 3: АНАЛИТИЧЕСКИЕ ФУНКЦИИ ===");
        
        try {
            functions.basic.Exp exp = new functions.basic.Exp();
            System.out.println("1. Экспонента:");
            System.out.println("   Границы: [" + exp.getLeftDomainBorder() + ", " + exp.getRightDomainBorder() + "]");
            System.out.println("   exp(0) = " + exp.getFunctionValue(0));
            System.out.println("   exp(1) = " + exp.getFunctionValue(1));
            System.out.println("   exp(-1) = " + exp.getFunctionValue(-1));
            
            functions.basic.Log log = new functions.basic.Log(2);
            System.out.println("\n2. Логарифм по основанию 2:");
            System.out.println("   Границы: [" + log.getLeftDomainBorder() + ", " + log.getRightDomainBorder() + "]");
            System.out.println("   log2(1) = " + log.getFunctionValue(1));
            System.out.println("   log2(2) = " + log.getFunctionValue(2));
            System.out.println("   log2(4) = " + log.getFunctionValue(4));
            System.out.println("   log2(0) = " + log.getFunctionValue(0));
            
            functions.basic.Sin sin = new functions.basic.Sin();
            functions.basic.Cos cos = new functions.basic.Cos();
            functions.basic.Tan tan = new functions.basic.Tan();
            
            System.out.println("\n3. Тригонометрические функции:");
            System.out.println("   sin(0) = " + sin.getFunctionValue(0));
            System.out.println("   cos(0) = " + cos.getFunctionValue(0));
            System.out.println("   tan(0) = " + tan.getFunctionValue(0));
            
            System.out.println("   sin(PI/2) = " + sin.getFunctionValue(Math.PI/2));
            System.out.println("   cos(PI/2) = " + cos.getFunctionValue(Math.PI/2));
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testAssignment4() {
        System.out.println("=== ЗАДАНИЕ 4: КОМБИНИРОВАННЫЕ ФУНКЦИИ ===");
        
        try {
            functions.basic.Sin sin = new functions.basic.Sin();
            functions.basic.Cos cos = new functions.basic.Cos();
            functions.basic.Exp exp = new functions.basic.Exp();
            
            functions.meta.Sum sinPlusCos = new functions.meta.Sum(sin, cos);
            System.out.println("1. Сумма sin + cos:");
            System.out.println("   Границы: [" + sinPlusCos.getLeftDomainBorder() + ", " + sinPlusCos.getRightDomainBorder() + "]");
            System.out.println("   (sin+cos)(0) = " + sinPlusCos.getFunctionValue(0));
            
            functions.meta.Mult sinTimesCos = new functions.meta.Mult(sin, cos);
            System.out.println("\n2. Произведение sin * cos:");
            System.out.println("   (sin*cos)(0) = " + sinTimesCos.getFunctionValue(0));
            System.out.println("   (sin*cos)(PI/4) = " + sinTimesCos.getFunctionValue(Math.PI/4));
            
            functions.meta.Power sinSquared = new functions.meta.Power(sin, 2);
            System.out.println("\n3. Квадрат синуса:");
            System.out.println("   sin^2(0) = " + sinSquared.getFunctionValue(0));
            System.out.println("   sin^2(PI/2) = " + sinSquared.getFunctionValue(Math.PI/2));
            
            functions.meta.Scale scaledSin = new functions.meta.Scale(sin, 2, 3);
            System.out.println("\n4. Масштабированный синус:");
            System.out.println("   scaledSin(PI) = " + scaledSin.getFunctionValue(Math.PI));
            
            functions.meta.Shift shiftedSin = new functions.meta.Shift(sin, Math.PI/2, 1);
            System.out.println("\n5. Сдвинутый синус:");
            System.out.println("   shiftedSin(0) = " + shiftedSin.getFunctionValue(0));
            
            functions.meta.Composition expOfSin = new functions.meta.Composition(sin, exp);
            System.out.println("\n6. Композиция exp(sin(x)):");
            System.out.println("   exp(sin(0)) = " + expOfSin.getFunctionValue(0));
            System.out.println("   exp(sin(PI/2)) = " + expOfSin.getFunctionValue(Math.PI/2));
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testAssignment5() {
        System.out.println("=== ЗАДАНИЕ 5: УТИЛИТНЫЙ КЛАСС FUNCTIONS ===");
        
        try {
            functions.basic.Sin sin = new functions.basic.Sin();
            functions.basic.Cos cos = new functions.basic.Cos();
            
            System.out.println("1. Тест shift:");
            functions.Function shifted = functions.Functions.shift(sin, 1, 2);
            System.out.println("   shifted(0) = " + shifted.getFunctionValue(0));
            
            System.out.println("\n2. Тест scale:");
            functions.Function scaled = functions.Functions.scale(sin, 2, 3);
            System.out.println("   scaled(PI/2) = " + scaled.getFunctionValue(Math.PI/2));
            
            System.out.println("\n3. Тест power:");
            functions.Function squared = functions.Functions.power(sin, 2);
            System.out.println("   squared(PI/2) = " + squared.getFunctionValue(Math.PI/2));
            
            System.out.println("\n4. Тест sum:");
            functions.Function sum = functions.Functions.sum(sin, cos);
            System.out.println("   sum(0) = " + sum.getFunctionValue(0));
            
            System.out.println("\n5. Тест mult:");
            functions.Function product = functions.Functions.mult(sin, cos);
            System.out.println("   product(PI/4) = " + product.getFunctionValue(Math.PI/4));
            
            System.out.println("\n6. Тест composition:");
            functions.Function composed = functions.Functions.composition(sin, cos);
            System.out.println("   composed(0) = " + composed.getFunctionValue(0));
            
            System.out.println("\n7. Приватный конструктор:");
            System.out.println("   Создание объектов Functions запрещено - корректно");
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testAssignment6() {
        System.out.println("=== ЗАДАНИЕ 6: ТАБУЛИРОВАНИЕ ФУНКЦИЙ ===");
        
        try {
            functions.basic.Sin sin = new functions.basic.Sin();
            
            System.out.println("1. Табуляция синуса на [0, PI] с 5 точками:");
            functions.TabulatedFunction tabulatedSin = functions.TabulatedFunctions.tabulate(sin, 0, Math.PI, 5);
            
            System.out.println("   Количество точек: " + tabulatedSin.getPointsCount());
            System.out.println("   Границы: [" + tabulatedSin.getLeftDomainBorder() + ", " + tabulatedSin.getRightDomainBorder() + "]");
            
            System.out.println("   Точки функции:");
            for (int i = 0; i < tabulatedSin.getPointsCount(); i++) {
                functions.FunctionPoint point = tabulatedSin.getPoint(i);
                System.out.printf("     [%d] x=%.3f, y=%.3f%n", i, point.getX(), point.getY());
            }
            
            System.out.println("\n2. Сравнение с аналитической функцией:");
            double testX = Math.PI / 4;
            double analyticValue = sin.getFunctionValue(testX);
            double tabulatedValue = tabulatedSin.getFunctionValue(testX);
            System.out.printf("   sin(PI/4): аналитическое=%.6f, табулированное=%.6f%n", analyticValue, tabulatedValue);
            
            System.out.println("\n3. Тест ошибок:");
            
            try {
                functions.basic.Log log = new functions.basic.Log(2);
                functions.TabulatedFunctions.tabulate(log, -1, 2, 5);
            } catch (IllegalArgumentException e) {
                System.out.println("   Выход за границы: " + e.getMessage());
            }
            
            try {
                functions.TabulatedFunctions.tabulate(sin, 0, Math.PI, 1);
            } catch (IllegalArgumentException e) {
                System.out.println("   Мало точек: " + e.getMessage());
            }
            
            try {
                functions.TabulatedFunctions.tabulate(sin, Math.PI, 0, 5);
            } catch (IllegalArgumentException e) {
                System.out.println("   Неправильные границы: " + e.getMessage());
            }
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testAssignment7() {
        System.out.println("=== ЗАДАНИЕ 7: ВВОД-ВЫВОД ФУНКЦИЙ ===");
        
        try {
            functions.basic.Sin sin = new functions.basic.Sin();
            functions.TabulatedFunction tabulatedSin = functions.TabulatedFunctions.tabulate(sin, 0, Math.PI, 5);
            
            System.out.println("Исходная функция (5 точек синуса на [0, PI]):");
            for (int i = 0; i < tabulatedSin.getPointsCount(); i++) {
                functions.FunctionPoint point = tabulatedSin.getPoint(i);
                System.out.printf("  [%d] x=%.3f, y=%.3f%n", i, point.getX(), point.getY());
            }
            
            System.out.println("\n1. Тест байтового ввода/вывода:");
            
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            functions.TabulatedFunctions.outputTabulatedFunction(tabulatedSin, byteOut);
            System.out.println("   Данные записаны в байтовый поток, размер: " + byteOut.size() + " байт");
            
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            functions.TabulatedFunction readFromBytes = functions.TabulatedFunctions.inputTabulatedFunction(byteIn);
            System.out.println("   Функция прочитана из байтового потока");
            System.out.println("   Количество точек: " + readFromBytes.getPointsCount());
            System.out.println("   Функции идентичны: " + compareFunctions(tabulatedSin, readFromBytes));
            
            System.out.println("\n2. Тест символьного ввода/вывода:");
            
            StringWriter stringWriter = new StringWriter();
            functions.TabulatedFunctions.writeTabulatedFunction(tabulatedSin, stringWriter);
            String stringData = stringWriter.toString();
            System.out.println("   Данные записаны в строку: \"" + stringData + "\"");
            
            StringReader stringReader = new StringReader(stringData);
            functions.TabulatedFunction readFromString = functions.TabulatedFunctions.readTabulatedFunction(stringReader);
            System.out.println("   Функция прочитана из строки");
            System.out.println("   Количество точек: " + readFromString.getPointsCount());
            System.out.println("   Функции идентичны: " + compareFunctions(tabulatedSin, readFromString));
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testAssignment8() {
        System.out.println("=== ЗАДАНИЕ 8: КОМПЛЕКСНОЕ ТЕСТИРОВАНИЕ ===");
        
        try {
            System.out.println("1. ТЕСТ АНАЛИТИЧЕСКИХ ФУНКЦИЙ:");
            functions.basic.Sin sin = new functions.basic.Sin();
            functions.basic.Cos cos = new functions.basic.Cos();
            
            System.out.println("   Значения sin и cos на [0, PI] с шагом 0.5:");
            System.out.println("   x\t\t sin(x)\t\t cos(x)");
            for (double x = 0; x <= Math.PI; x += 0.5) {
                System.out.printf("   %.1f\t\t %.6f\t %.6f%n", x, sin.getFunctionValue(x), cos.getFunctionValue(x));
            }
            
            System.out.println("\n2. ТЕСТ ТАБУЛИРОВАННЫХ АНАЛОГОВ:");
            functions.TabulatedFunction tabulatedSin = functions.TabulatedFunctions.tabulate(sin, 0, Math.PI, 6);
            functions.TabulatedFunction tabulatedCos = functions.TabulatedFunctions.tabulate(cos, 0, Math.PI, 6);
            
            System.out.println("   Сравнение в точках табуляции:");
            System.out.println("   x\t\t sin(x)\t\t tab_sin(x)\t cos(x)\t\t tab_cos(x)");
            for (int i = 0; i < tabulatedSin.getPointsCount(); i++) {
                double x = tabulatedSin.getPointX(i);
                double sinVal = sin.getFunctionValue(x);
                double cosVal = cos.getFunctionValue(x);
                double tabSinVal = tabulatedSin.getFunctionValue(x);
                double tabCosVal = tabulatedCos.getFunctionValue(x);
                
                System.out.printf("   %.1f\t\t %.6f\t %.6f\t %.6f\t %.6f%n", 
                    x, sinVal, tabSinVal, cosVal, tabCosVal);
            }
            
            System.out.println("\n3. ТЕСТ СУММЫ КВАДРАТОВ:");
            functions.Function sinSquared = functions.Functions.power(tabulatedSin, 2);
            functions.Function cosSquared = functions.Functions.power(tabulatedCos, 2);
            functions.Function sumOfSquares = functions.Functions.sum(sinSquared, cosSquared);
            
            System.out.println("   sin(x)^2 + cos(x)^2 для разных количеств точек:");
            for (int pointsCount : new int[]{5, 10, 20}) {
                functions.TabulatedFunction tabSin = functions.TabulatedFunctions.tabulate(sin, 0, Math.PI, pointsCount);
                functions.TabulatedFunction tabCos = functions.TabulatedFunctions.tabulate(cos, 0, Math.PI, pointsCount);
                
                functions.Function sinSq = functions.Functions.power(tabSin, 2);
                functions.Function cosSq = functions.Functions.power(tabCos, 2);
                functions.Function sum = functions.Functions.sum(sinSq, cosSq);
                
                System.out.println("   Точки: " + pointsCount);
                for (double x = 0; x <= Math.PI; x += 1) {
                    double value = sum.getFunctionValue(x);
                    System.out.printf("     x=%.1f: %.6f%n", x, value);
                }
            }
            
            System.out.println("\n4. ТЕСТ ФАЙЛОВЫХ ОПЕРАЦИЙ:");
            
            functions.basic.Exp exp = new functions.basic.Exp();
            functions.TabulatedFunction tabulatedExp = functions.TabulatedFunctions.tabulate(exp, 0, 10, 11);
            
            try (FileWriter writer = new FileWriter("exp_function.txt")) {
                functions.TabulatedFunctions.writeTabulatedFunction(tabulatedExp, writer);
            }
            System.out.println("   Экспонента записана в exp_function.txt");
            
            try (FileReader reader = new FileReader("exp_function.txt")) {
                functions.TabulatedFunction readExp = functions.TabulatedFunctions.readTabulatedFunction(reader);
                System.out.println("   Экспонента прочитана из файла");
                System.out.println("   Сравнение значений:");
                for (double x = 0; x <= 10; x += 2) {
                    double original = tabulatedExp.getFunctionValue(x);
                    double read = readExp.getFunctionValue(x);
                    System.out.printf("     x=%.0f: исходная=%.6f, прочитанная=%.6f%n", x, original, read);
                }
            }
            
            functions.basic.Log log = new functions.basic.Log(Math.E);
            functions.TabulatedFunction tabulatedLog = functions.TabulatedFunctions.tabulate(log, 1, 10, 10);
            
            try (FileOutputStream out = new FileOutputStream("log_function.bin")) {
                functions.TabulatedFunctions.outputTabulatedFunction(tabulatedLog, out);
            }
            System.out.println("   Логарифм записан в log_function.bin");
            
            try (FileInputStream in = new FileInputStream("log_function.bin")) {
                functions.TabulatedFunction readLog = functions.TabulatedFunctions.inputTabulatedFunction(in);
                System.out.println("   Логарифм прочитан из файла");
            }
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testAssignment9() {
        System.out.println("=== ЗАДАНИЕ 9: СЕРИАЛИЗАЦИЯ ===");
        
        try {
            functions.basic.Exp exp = new functions.basic.Exp();
            functions.basic.Log log = new functions.basic.Log(Math.E);
            functions.Function logOfExp = functions.Functions.composition(log, exp);
            
            functions.TabulatedFunction tabulatedFunc = functions.TabulatedFunctions.tabulate(logOfExp, 0, 10, 11);
            
            System.out.println("Исходная функция ln(exp(x)) на [0, 10]:");
            for (int i = 0; i < tabulatedFunc.getPointsCount(); i++) {
                functions.FunctionPoint point = tabulatedFunc.getPoint(i);
                System.out.printf("  [%d] x=%.1f, y=%.6f%n", i, point.getX(), point.getY());
            }
            
            System.out.println("\n1. СЕРИАЛИЗАЦИЯ С Serializable:");
            testSerialization(tabulatedFunc, "function_serializable.ser");
            
            System.out.println("\n2. СЕРИАЛИЗАЦИЯ С Externalizable:");
            testSerialization(tabulatedFunc, "function_externalizable.ser");
            
            System.out.println("\n3. СРАВНЕНИЕ ФАЙЛОВ:");
            File serializableFile = new File("function_serializable.ser");
            File externalizableFile = new File("function_externalizable.ser");
            File textFile = new File("exp_function.txt");
            File binaryFile = new File("log_function.bin");
            
            System.out.println("   Serializable: " + serializableFile.length() + " байт");
            System.out.println("   Externalizable: " + externalizableFile.length() + " байт");
            System.out.println("   Текстовый: " + textFile.length() + " байт");
            System.out.println("   Бинарный: " + binaryFile.length() + " байт");
            
            System.out.println("\n4. СРАВНЕНИЕ ЗНАЧЕНИЙ ПОСЛЕ ДЕСЕРИАЛИЗАЦИИ:");
            functions.TabulatedFunction serFunc, extFunc;
            
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("function_serializable.ser"))) {
                serFunc = (functions.TabulatedFunction) in.readObject();
            }
            
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("function_externalizable.ser"))) {
                extFunc = (functions.TabulatedFunction) in.readObject();
            }
            
            System.out.println("   x\t\tИсходная\tSerializable\tExternalizable");
            for (double x = 0; x <= 10; x += 1) {
                double original = tabulatedFunc.getFunctionValue(x);
                double serValue = serFunc.getFunctionValue(x);
                double extValue = extFunc.getFunctionValue(x);
                System.out.printf("   %.0f\t\t%.6f\t%.6f\t%.6f%n", x, original, serValue, extValue);
            }
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testSerialization(functions.TabulatedFunction func, String filename) throws Exception {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(func);
        }
        System.out.println("   Записано в " + filename);
        
        functions.TabulatedFunction deserializedFunc;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            deserializedFunc = (functions.TabulatedFunction) in.readObject();
        }
        System.out.println("   Прочитано из " + filename);
        
        File file = new File(filename);
        System.out.println("   Размер файла: " + file.length() + " байт");
        System.out.println("   Функция корректна: " + compareFunctions(func, deserializedFunc));
    }
    
    private static boolean compareFunctions(functions.TabulatedFunction f1, functions.TabulatedFunction f2) {
        if (f1.getPointsCount() != f2.getPointsCount()) return false;
        
        for (int i = 0; i < f1.getPointsCount(); i++) {
            if (Math.abs(f1.getPointX(i) - f2.getPointX(i)) > 1e-10 ||
                Math.abs(f1.getPointY(i) - f2.getPointY(i)) > 1e-10) {
                return false;
            }
        }
        return true;
    }
}