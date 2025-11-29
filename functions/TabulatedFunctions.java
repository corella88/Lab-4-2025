package functions;

import java.io.*;
import java.util.StringTokenizer;

public final class TabulatedFunctions {
    // Приватный конструктор - нельзя создавать объекты
    private TabulatedFunctions() {
        throw new AssertionError("Нельзя создавать объекты класса TabulatedFunctions");
    }
    
    public static TabulatedFunction tabulate(Function function, double leftX, double rightX, int pointsCount) {
        // проверка границ табулирования
        if (leftX < function.getLeftDomainBorder()) {
            throw new IllegalArgumentException("Левая граница табулирования " + leftX + 
                " выходит за левую границу области определения " + function.getLeftDomainBorder());
        }
        
        if (rightX > function.getRightDomainBorder()) {
            throw new IllegalArgumentException("Правая граница табулирования " + rightX + 
                " выходит за правую границу области определения " + function.getRightDomainBorder());
        }
        
        if (pointsCount < 2) {
            throw new IllegalArgumentException("Количество точек должно быть не менее 2");
        }
        
        if (leftX >= rightX) {
            throw new IllegalArgumentException("Левая граница должна быть меньше правой");
        }
        
        // Создаем массив значений Y с более точным вычислением
        double[] values = new double[pointsCount];
        double step = (rightX - leftX) / (pointsCount - 1);
        
        for (int i = 0; i < pointsCount; i++) {
            double x = leftX + i * step;
            
            // Для последней точки используем точное значение rightX чтобы избежать ошибок округления
            if (i == pointsCount - 1) {
                x = rightX;
            }
            
            values[i] = function.getFunctionValue(x);
        }
        
        return new ArrayTabulatedFunction(leftX, rightX, values);
    }

    // Вывод табулированной функции в байтовый поток
    public static void outputTabulatedFunction(TabulatedFunction function, OutputStream out) throws IOException {
        DataOutputStream dataOut = new DataOutputStream(out);
        
        // Записываем количество точек
        dataOut.writeInt(function.getPointsCount());
        
        // Записываем все точки (x, y)
        for (int i = 0; i < function.getPointsCount(); i++) {
            FunctionPoint point = function.getPoint(i);
            dataOut.writeDouble(point.getX());
            dataOut.writeDouble(point.getY());
        }
        
        dataOut.flush();
    }

    // Ввод табулированной функции из байтового потока
    public static TabulatedFunction inputTabulatedFunction(InputStream in) throws IOException {
        DataInputStream dataIn = new DataInputStream(in);
        
        // Читаем количество точек
        int pointsCount = dataIn.readInt();
        
        // Читаем точки
        FunctionPoint[] points = new FunctionPoint[pointsCount];
        for (int i = 0; i < pointsCount; i++) {
            double x = dataIn.readDouble();
            double y = dataIn.readDouble();
            points[i] = new FunctionPoint(x, y);
        }
        
        // Создаем и возвращаем функцию
        return new ArrayTabulatedFunction(points);
    }

    // Запись табулированной функции в символьный поток
    public static void writeTabulatedFunction(TabulatedFunction function, Writer out) throws IOException {
        PrintWriter writer = new PrintWriter(out);
        
        // Записываем количество точек
        writer.print(function.getPointsCount());
        writer.print(" ");
        
        // Записываем все точки через пробел
        for (int i = 0; i < function.getPointsCount(); i++) {
            FunctionPoint point = function.getPoint(i);
            double x = point.getX();
            double y = point.getY();
            
            // ИСПРАВЛЕНИЕ: округляем очень маленькие значения до нуля при записи
            if (Math.abs(y) < 1e-10) {
                y = 0.0;
            }
            
            writer.print(x);
            writer.print(" ");
            writer.print(y);
            if (i < function.getPointsCount() - 1) {
                writer.print(" ");
            }
        }
        
        writer.flush();
    }
    
    // Чтение табулированной функции из символьного потока
    public static TabulatedFunction readTabulatedFunction(Reader in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        
        // Читаем количество точек
        tokenizer.nextToken();
        int pointsCount = (int) tokenizer.nval;
        
        // Читаем точки
        FunctionPoint[] points = new FunctionPoint[pointsCount];
        for (int i = 0; i < pointsCount; i++) {
            tokenizer.nextToken();
            double x = tokenizer.nval;
            tokenizer.nextToken();
            double y = tokenizer.nval;
            
            // Исправление: если значение очень близко к нулю, считаем его нулём
            if (Math.abs(y) < 1e-10) {
                y = 0.0;
            }
            
            points[i] = new FunctionPoint(x, y);
        }
        
        // Создаем и возвращаем функцию
        return new ArrayTabulatedFunction(points);
    }
}
