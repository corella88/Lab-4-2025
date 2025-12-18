import java.io.*;

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
            
            functions.TabulatedFunction arrayFunc = new functions.ArrayTabulatedFunction(points);
            System.out.println("ArrayTabulatedFunction создана. Точек: " + arrayFunc.getPointsCount());
            
            functions.TabulatedFunction linkedFunc = new functions.LinkedListTabulatedFunction(points);
            System.out.println("LinkedListTabulatedFunction создана. Точек: " + linkedFunc.getPointsCount());
            
            System.out.println("Тест ошибок:");
            
            try {
                functions.FunctionPoint[] fewPoints = {new functions.FunctionPoint(0, 0)};
                new functions.ArrayTabulatedFunction(fewPoints);
            } catch (IllegalArgumentException e) {
                System.out.println("Мало точек: " + e.getMessage());
            }
            
            try {
                functions.FunctionPoint[] unorderedPoints = {
                    new functions.FunctionPoint(0, 0),
                    new functions.FunctionPoint(2, 4), 
                    new functions.FunctionPoint(1, 1)
                };
                new functions.LinkedListTabulatedFunction(unorderedPoints);
            } catch (IllegalArgumentException e) {
                System.out.println("Неупорядоченные точки: " + e.getMessage());
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
            
            System.out.println("ArrayTabulatedFunction instanceof Function: " + (arrayFunc instanceof functions.Function));
            System.out.println("LinkedListTabulatedFunction instanceof Function: " + (linkedFunc instanceof functions.Function));
            
            System.out.println("Array - границы: [" + arrayFunc.getLeftDomainBorder() + ", " + arrayFunc.getRightDomainBorder() + "]");
            System.out.println("Array - f(1.5) = " + arrayFunc.getFunctionValue(1.5));
            
            System.out.println("LinkedList - границы: [" + linkedFunc.getLeftDomainBorder() + ", " + linkedFunc.getRightDomainBorder() + "]");
            System.out.println("LinkedList - f(1.5) = " + linkedFunc.getFunctionValue(1.5));
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testAssignment3() {
        System.out.println("=== ЗАДАНИЕ 3: АНАЛИТИЧЕСКИЕ ФУНКЦИИ ===");
        
        try {
            functions.basic.Exp exp = new functions.basic.Exp();
            System.out.println("Экспонента:");
            System.out.println("Границы: [" + exp.getLeftDomainBorder() + ", " + exp.getRightDomainBorder() + "]");
            System.out.println("exp(0) = " + exp.getFunctionValue(0));
            System.out.println("exp(1) = " + exp.getFunctionValue(1));
            System.out.println("exp(-1) = " + exp.getFunctionValue(-1));
            
            functions.basic.Log log = new functions.basic.Log(2);
            System.out.println("\nЛогарифм по основанию 2:");
            System.out.println("Границы: [" + log.getLeftDomainBorder() + ", " + log.getRightDomainBorder() + "]");
            System.out.println("log2(1) = " + log.getFunctionValue(1));
            System.out.println("log2(2) = " + log.getFunctionValue(2));
            System.out.println("log2(4) = " + log.getFunctionValue(4));
            System.out.println("log2(0) = " + log.getFunctionValue(0));
            
            functions.basic.Sin sin = new functions.basic.Sin();
            functions.basic.Cos cos = new functions.basic.Cos();
            
            System.out.println("\nТригонометрические функции:");
            System.out.println("sin(0) = " + sin.getFunctionValue(0));
            System.out.println("cos(0) = " + cos.getFunctionValue(0));
            System.out.println("sin(PI/2) = " + sin.getFunctionValue(Math.PI/2));
            System.out.println("cos(PI/2) = " + cos.getFunctionValue(Math.PI/2));
            
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
            
            functions.meta.Sum sinPlusCos = new functions.meta.Sum(sin, cos);
            System.out.println("Сумма sin + cos:");
            System.out.println("(sin+cos)(0) = " + sinPlusCos.getFunctionValue(0));
            
            functions.meta.Mult sinTimesCos = new functions.meta.Mult(sin, cos);
            System.out.println("\nПроизведение sin * cos:");
            System.out.println("(sin*cos)(0) = " + sinTimesCos.getFunctionValue(0));
            System.out.println("(sin*cos)(PI/4) = " + sinTimesCos.getFunctionValue(Math.PI/4));
            
            functions.meta.Power sinSquared = new functions.meta.Power(sin, 2);
            System.out.println("\nКвадрат синуса:");
            System.out.println("sin^2(0) = " + sinSquared.getFunctionValue(0));
            System.out.println("sin^2(PI/2) = " + sinSquared.getFunctionValue(Math.PI/2));
            
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
            
            System.out.println("Тест sum:");
            functions.Function sum = functions.Functions.sum(sin, cos);
            System.out.println("sum(0) = " + sum.getFunctionValue(0));
            
            System.out.println("\nТест mult:");
            functions.Function product = functions.Functions.mult(sin, cos);
            System.out.println("product(PI/4) = " + product.getFunctionValue(Math.PI/4));
            
            System.out.println("\nТест composition:");
            functions.Function composed = functions.Functions.composition(sin, cos);
            System.out.println("composed(0) = " + composed.getFunctionValue(0));
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testAssignment6() {
        System.out.println("=== ЗАДАНИЕ 6: ТАБУЛИРОВАНИЕ ФУНКЦИЙ ===");
        
        try {
            functions.basic.Sin sin = new functions.basic.Sin();
            
            functions.TabulatedFunction tabulatedSin = functions.TabulatedFunctions.tabulate(sin, 0, Math.PI, 5);
            
            System.out.println("Табуляция синуса на [0, PI] с 5 точками:");
            System.out.println("Точек: " + tabulatedSin.getPointsCount());
            
            System.out.println("Точки функции:");
            for (int i = 0; i < tabulatedSin.getPointsCount(); i++) {
                functions.FunctionPoint point = tabulatedSin.getPoint(i);
                System.out.printf("  [%d] x=%.3f, y=%.3f%n", i, point.getX(), point.getY());
            }
            
            System.out.println("\nСравнение с аналитической функцией:");
            double testX = Math.PI / 4;
            double analyticValue = sin.getFunctionValue(testX);
            double tabulatedValue = tabulatedSin.getFunctionValue(testX);
            System.out.printf("sin(PI/4): аналитическое=%.6f, табулированное=%.6f%n", analyticValue, tabulatedValue);
            
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
            
            System.out.println("Исходная функция:");
            for (int i = 0; i < tabulatedSin.getPointsCount(); i++) {
                functions.FunctionPoint point = tabulatedSin.getPoint(i);
                System.out.printf("  [%d] x=%.3f, y=%.3f%n", i, point.getX(), point.getY());
            }
            
            System.out.println("\n1. Тест байтового ввода/вывода:");
            
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            functions.TabulatedFunctions.outputTabulatedFunction(tabulatedSin, byteOut);
            System.out.println("Записано, размер: " + byteOut.size() + " байт");
            
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            functions.TabulatedFunction readFromBytes = functions.TabulatedFunctions.inputTabulatedFunction(byteIn);
            System.out.println("Прочитано. Точек: " + readFromBytes.getPointsCount());
            
            System.out.println("\n2. Тест символьного ввода/вывода:");
            
            StringWriter stringWriter = new StringWriter();
            functions.TabulatedFunctions.writeTabulatedFunction(tabulatedSin, stringWriter);
            String stringData = stringWriter.toString();
            System.out.println("Записано в строку");
            
            StringReader stringReader = new StringReader(stringData);
            functions.TabulatedFunction readFromString = functions.TabulatedFunctions.readTabulatedFunction(stringReader);
            System.out.println("Прочитано из строки. Точек: " + readFromString.getPointsCount());
            
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
            
            System.out.println("sin и cos на [0, PI] с шагом 0.5:");
            for (double x = 0; x <= Math.PI; x += 0.5) {
                System.out.printf("  x=%.1f: sin=%.6f, cos=%.6f%n", x, sin.getFunctionValue(x), cos.getFunctionValue(x));
            }
            
            System.out.println("\n2. ТЕСТ ФАЙЛОВЫХ ОПЕРАЦИЙ:");
            
            functions.basic.Exp exp = new functions.basic.Exp();
            functions.TabulatedFunction tabulatedExp = functions.TabulatedFunctions.tabulate(exp, 0, 10, 11);
            
            try (FileWriter writer = new FileWriter("exp_function.txt")) {
                functions.TabulatedFunctions.writeTabulatedFunction(tabulatedExp, writer);
            }
            System.out.println("Экспонента записана в exp_function.txt");
            
            try (FileReader reader = new FileReader("exp_function.txt")) {
                functions.TabulatedFunction readExp = functions.TabulatedFunctions.readTabulatedFunction(reader);
                System.out.println("Экспонента прочитана из файла");
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
            functions.basic.Log ln = new functions.basic.Log(Math.E);
            
            functions.Function lnOfExp = functions.Functions.composition(ln, exp);
            
            System.out.println("Тест ln(exp(x)):");
            System.out.println("x\tln(exp(x))\tОжидаемое (x)\tРазница");
            
            double[] testPoints = {-2, -1, 0, 1, 2, 3, 4, 5};
            
            for (double x : testPoints) {
                double result = lnOfExp.getFunctionValue(x);
                double expected = x;
                double diff = Math.abs(result - expected);
                
                System.out.printf("%6.1f\t%10.6f\t%10.6f\t", x, result, expected);
                
                if (diff < 1e-10) {
                    System.out.println("< 1e-10");
                } else {
                    System.out.printf("%10.6f%n", diff);
                }
            }
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();
    }
}