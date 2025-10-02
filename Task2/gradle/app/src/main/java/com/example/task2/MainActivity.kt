package com.example.task2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.task2.ui.theme.Task2Theme
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Task2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)) {
                        QuizScreen()
                    }
                }
            }
        }
    }
}

data class Question(
    val text: String,
    val options: List<String>,
    val correctIndex: Int
)

private val questions: List<Question> = listOf(
    Question(
        text = "Какая компания производит модель Mustang?",
        options = listOf("Chevrolet", "Ford", "Dodge", "Tesla"),
        correctIndex = 1
    ),
    Question(
        text = "Какой тип привода обозначается как RWD?",
        options = listOf("Полный привод", "Передний привод", "Задний привод", "Гибридный привод"),
        correctIndex = 2
    ),
    Question(
        text = "Какая марка выпускает модель 911?",
        options = listOf("Ferrari", "Porsche", "Lamborghini", "Audi"),
        correctIndex = 1
    ),
    Question(
        text = "Как измеряется мощность двигателя в системе SI?",
        options = listOf("Лошадиные силы", "Ньютон-метры", "Киловатты", "Вольты"),
        correctIndex = 2
    ),
    Question(
        text = "Аббревиатура ABS означает…",
        options = listOf("Система стабилизации", "Антиблокировочная система тормозов", "Система распределения тормозов", "Круиз-контроль"),
        correctIndex = 1
    ),
    Question(
        text = "Что делает турбонаддув?",
        options = listOf("Уменьшает расход топлива", "Повышает давление воздуха во впуске", "Охлаждает двигатель", "Снижает выбросы CO2"),
        correctIndex = 1
    ),
    Question(
        text = "Какой тип трансмиссии не имеет фиксированных передач?",
        options = listOf("Механическая", "АКПП гидротрансформатор", "Роботизированная", "Вариатор (CVT)"),
        correctIndex = 3
    ),
    Question(
        text = "Что означает индекс 4MATIC у Mercedes-Benz?",
        options = listOf("Гибрид", "Спортивная версия", "Полный привод", "Дизель"),
        correctIndex = 2
    ),
    Question(
        text = "Какой бензин с более высоким октановым числом?",
        options = listOf("92", "95", "98", "91"),
        correctIndex = 2
    ),
    Question(
        text = "Что такое крутящий момент?",
        options = listOf("Скорость автомобиля", "Сила вращения", "Расход топлива", "Объём двигателя"),
        correctIndex = 1
    ),
    Question(
        text = "Какая страна родина марки Toyota?",
        options = listOf("Китай", "Корея", "Япония", "Сингапур"),
        correctIndex = 2
    ),
    Question(
        text = "Какой элемент отвечает за очистку выхлопных газов?",
        options = listOf("Турбина", "Каталитический нейтрализатор", "Интеркулер", "Датчик кислорода"),
        correctIndex = 1
    ),
    Question(
        text = "Какой кузов у BMW X5?",
        options = listOf("Седан", "Хэтчбек", "Кроссовер/SUV", "Купе"),
        correctIndex = 2
    ),
    Question(
        text = "Что означает FWD?",
        options = listOf("Полный привод", "Передний привод", "Задний привод", "Полупривод"),
        correctIndex = 1
    ),
    Question(
        text = "Какая марка известна эмблемой с быком?",
        options = listOf("Ferrari", "Lamborghini", "Maserati", "Bugatti"),
        correctIndex = 1
    ),
    Question(
        text = "Какой автомобиль считается первым серийным электрокаром Tesla?",
        options = listOf("Model S", "Roadster", "Model 3", "Model X"),
        correctIndex = 1
    ),
    Question(
        text = "Что показывает тахометр?",
        options = listOf("Скорость", "Обороты двигателя", "Температуру", "Запас хода"),
        correctIndex = 1
    ),
    Question(
        text = "Какой тип топлива у большинства современных дизелей?",
        options = listOf("АИ-95", "ДТ", "Сжиженный газ", "Водород"),
        correctIndex = 1
    ),
    Question(
        text = "Где расположен двигатель у Porsche 911?",
        options = listOf("Спереди продольно", "Спереди поперечно", "Середина", "Сзади"),
        correctIndex = 3
    ),
    Question(
        text = "Что делает интеркулер?",
        options = listOf("Охлаждает наддувочный воздух", "Охлаждает масло", "Нагревает салон", "Повышает давление топлива"),
        correctIndex = 0
    ),
    Question(
        text = "Какой бренд выпускает модель Civic?",
        options = listOf("Honda", "Hyundai", "Mazda", "Nissan"),
        correctIndex = 0
    ),
    Question(
        text = "Чем измеряют объём двигателя?",
        options = listOf("Киловатты", "Литры/кубические сантиметры", "Ньютон-метры", "Ом"),
        correctIndex = 1
    ),
    Question(
        text = "Какая система помогает трогаться в гору?",
        options = listOf("ESP", "TPMS", "HSA/Hill Start Assist", "LDW"),
        correctIndex = 2
    ),
    Question(
        text = "Что означает значок TPMS?",
        options = listOf("Датчик давления в шинах", "Система удержания полосы", "Датчик дождя", "Парктроник"),
        correctIndex = 0
    ),
    Question(
        text = "Какой кузов у Audi A4 Avant?",
        options = listOf("Седан", "Универсал", "Купе", "Кабриолет"),
        correctIndex = 1
    ),
    Question(
        text = "Что такое клиренс?",
        options = listOf("Ширина кузова", "Длина базы", "Дорожный просвет", "Радиус разворота"),
        correctIndex = 2
    ),
    Question(
        text = "Какой элемент трансмиссии соединяет двигатель и КПП?",
        options = listOf("Сцепление/Гидротрансформатор", "Кардан", "Дифференциал", "ШРУС"),
        correctIndex = 0
    ),
    Question(
        text = "Что означает ECO режим?",
        options = listOf("Спортивная настройка", "Повышенная экономичность", "Полный привод", "Грязевая настройка"),
        correctIndex = 1
    ),
    Question(
        text = "Какой бренд владеет маркой Bugatti (в 2020-х)?",
        options = listOf("Volkswagen Group", "Stellantis", "Toyota", "GM"),
        correctIndex = 0
    ),
    Question(
        text = "Что делает система ESP?",
        options = listOf("Контроль устойчивости", "Контроль давления", "Круиз-контроль", "Парковка"),
        correctIndex = 0
    )
    /* Удалён, чтобы всего было 30 вопросов
    ,Question(
        text = "Какой привод чаще у Subaru?",
        options = listOf("Передний", "Задний", "Полный (Symmetrical AWD)", "Гидравлический"),
        correctIndex = 2
    )
    */
)

private fun shuffleQuestionOptions(original: Question): Question {
    val indices = original.options.indices.toList().shuffled()
    val newOptions = indices.map { original.options[it] }
    val newCorrect = indices.indexOf(original.correctIndex)
    return original.copy(options = newOptions, correctIndex = newCorrect)
}

@Composable
fun QuizScreen() {
    val context = LocalContext.current
    var currentIndex by remember { mutableIntStateOf(0) }
    var score by remember { mutableIntStateOf(0) }
    var selectedIndex by remember { mutableStateOf<Int?>(null) }
    var answered by remember { mutableStateOf(false) }
    var finished by remember { mutableStateOf(false) }
    // Перемешанный список вопросов и вариантов
    var randomized by remember { mutableStateOf(questions.shuffled().map { shuffleQuestionOptions(it) }) }

    if (finished) {
        ResultScreen(score = score, total = randomized.size) {
            currentIndex = 0
            score = 0
            selectedIndex = null
            answered = false
            finished = false
            randomized = questions.shuffled().map { shuffleQuestionOptions(it) }
        }
        return
    }

    val question = randomized[currentIndex]

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Вопрос ${currentIndex + 1} из ${randomized.size}",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(Modifier.height(12.dp))
        Text(
            text = question.text,
            style = MaterialTheme.typography.titleLarge,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(16.dp))

        question.options.forEachIndexed { index, option ->
            val isSelected = selectedIndex == index
            OutlinedButton(
                onClick = {
                    if (!answered) {
                        selectedIndex = index
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                enabled = !answered || isSelected
            ) {
                Text(text = option)
            }
        }

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                if (!answered) {
                    if (selectedIndex == null) {
                        Toast.makeText(context, "Выберите вариант", Toast.LENGTH_SHORT).show()
                        return@Button
                    }
                    val correct = selectedIndex == question.correctIndex
                    if (correct) score++
                    Toast.makeText(
                        context,
                        if (correct) "Верно" else "Неверно. Правильный: ${question.options[question.correctIndex]}",
                        Toast.LENGTH_SHORT
                    ).show()
                    answered = true
                } else {
                    // Далее
                    if (currentIndex < questions.lastIndex) {
                        currentIndex++
                        selectedIndex = null
                        answered = false
                    } else {
                        finished = true
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = if (!answered) "Проверить" else if (currentIndex < questions.lastIndex) "Далее" else "Завершить")
        }
    }
}

@Composable
fun ResultScreen(score: Int, total: Int, onRestart: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Результат",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "Вы ответили верно на $score из $total",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(Modifier.height(24.dp))
        Button(onClick = onRestart, modifier = Modifier.fillMaxWidth()) {
            Text("Начать заново")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuizPreview() {
    Task2Theme {
        QuizScreen()
    }
}