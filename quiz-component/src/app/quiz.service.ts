import { Injectable } from '@angular/core';

interface Quiz{
    question: string;
    answer: { option: string, correct: boolean } [];
}

@Injectable({
  providedIn: 'root'
})
export class QuizService {
  quizzes: Quiz[] = [
    {
question: "What is Neurodiversity?",
answer: [
{option: "The biological variety and variability of life on Earth",  correct: false},
{option: "The practice or quality of including or involving people from a range of different social and ethnic backgrounds and of different genders, sexual orientations, et", correct: false},
{option: "The Goodfeathers from the Animaniacs", correct: false},
{option: "A variation in the human brain regarding sociability, learning, attention, mood and other mental functions in a non-pathological sense", correct: true},
]
},
{
question: "What is a comorbidity?",
 answer: [
{ option: "The rate of disease in a population", correct: false },
{ option: "Is the presence of one or more additional conditions often co-occurring with a primary condition", correct: true },
{ option: "A disorder involving excessive body fat that increases the risk of health problems ", correct: false },
{ option: "Wile E. Coyote", correct: false },
 ]
},
{
question:  "What is Masking?",
answer: [
{ option: "A song by Future", correct: false },
{ option: "A classical form of Japanese dance-drama", correct: false },
{ option: "A tool uses to decrease the risk of getting Covid-19",  correct: false },
{ option: "Camouflaging is a term used to describe neurodiverse individuals who seek to hide or minimize their autism traits to fit in with the neurotypical world", correct: true },
]
},
 {
question: "What is Tourette Syndrome?",
answer: [
{ option: "A nervous system disorder involving repetitive movements or unwanted sounds", correct: true },
{ option: "A genetic mutation that affects bone growth", correct: false },
{ option: "A heavy metal rock bank that become popular in the UK in the 80's", correct: false },
{ option: "The name of a Pasta Dish", correct: false },
]
},
{
question: " Geez, Brain. What are we going to do tonight?",
answer: [
{ option: "Order Pizza", correct: false },
{ option: "The same thing we do every night, Pinky", correct: true },
{ option: "Watch Korean drama", correct: false },
{ option: "Study recursions", correct: false },
]
},

{
question:  "What percentage of the population is thought to be neurodiverse?",
answer: [
{ option: "100%", correct: false },
{ option: "20-40%", correct: true},
{ option: "50-70%", correct: false },
{ option: "5-20%", correct: false },
]
},
{
question:  " Dyslexia is?",
answer: [
{ option: "A super power that allows you to misspell everything", correct: false },
{ option: "A learning disorder characterized by difficulty reading", correct: true },
{ option: " A place in Ukraine world famous for sword fighting", correct: false },
{ option: "A wrestling move created by the Iron Sheik", correct: false },
]
},
{
question: "Why isn't Tina in Bob's Burgers 'That kind of Autistic'?",
answer: [
{ option: "She isn't Rain Man", correct: false },
{ option: "She is the other kind of Autistic", correct: false },
{ option: "She paints instead of plays the piano", correct: false },
{ option: "Is known as a “spectrum” disorder because there is wide variation in the type and severity of symptoms people experience", correct: true },
]
},
{
question:  "What is the name of condition that affects an individual's ability to do basic arithmetic?",
answer: [
{ option: "Dyscalculia", correct: true },
{ option: "Dyspraxia", correct: false },
{ option: "Dysgraphia", correct: false },
{ option: "Dyslexia", correct: false },
]
},
{
question:  "ADHD/ADD is often characterized by...?",
answer: [
{ option: "Accepting George R.R. Martin is never releasing the next book", correct: false },
{ option: " Comfort in organizing and sorting items such as toys",correct: false },
{ option: " Godlike levels of sarcasm", correct: false },
{ option: " Marked inattention, impulsivity, and, in some cases, hyperactivity", correct: true },
]
},
{
question:  " What is an IEP?",
answer: [
{ option: "Index of Effective Participation", correct: false },
{ option: "Individualized Education Program", correct: true },
{ option: "Institute of Experimental Psychology", correct: false },
{ option: "Iso-Electric Point", correct: false }
]
},
{
question:  "___ is a mental disorder that causes unusual shifts in mood, energy, activity levels, concentration, and the ability to carry out day-to-day tasks?",
answer: [
{ option: "Bipolar disorder", correct: true },
{ option: "A New Yorker", correct: false },
{ option: "Otaku", correct: false },
{ option: "Kingdom Hearts c", correct: false },
]
},
{
question:  "Who coined the term neurodiversity?",
answer: [
{ option: "Robert Kirkman, an author", correct: false },
{ option: "Batman, the dark knight", correct: false },
{ option: "Judy Singer, a sociologist", correct: true },
{ option: "Al Capone, a business man", correct: false },
]
},
{
question:  "Who was the host of the Reading Rainbow?",
answer: [
{ option: "LeVar Burton", correct: true },
{ option: "Mr. Rogers", correct: false },
{ option: "Bill Nye", correct: false },
{ option: "Samuel l. Jackson", correct: false },
]
},
 {
question:  "Hooked on phonics is ____?",
answer: [
{ option: "A popular recreational drug used to enhance your reading comprehension", correct: false },
{ option: "A popular breakfast cereal caused you to go cuckoo for Cocoa Puffs", correct: false },
{ option: "Whatever Shaggy was on in Scooby-Doo", correct: false },
{ option: "a commercial brand of educational materials, originally designed for reading education through phonetics", correct: true },
]
},
{
question:  "Who is the great rapper of all time?",
answer: [
{ option: "Jay Z", correct: false },
{ option: "Dylan", correct: true },
{ option: "Biggie", correct: false },
{ option: "Random Mumble Rapper", correct: false },
]
},
{
question:  " Why are men  more frequently diagnosed with autism than women?",
answer: [
{ option: "Lack of research on how the condition presents different in women", correct: true },
{ option: "Genetics", correct: false },
{ option: "It is a men specific disorder ", correct: false },
{ option: "Boys just want to have fun", correct: false },
]
},
{
question:  "What wouldn't Sam-I-Am do?",
answer: [
{ option: "Fly a kite", correct: false },
{ option: "Ride a Bike", correct: false },
{ option: "Eat Green Eggs and Ham", correct: true },
{ option: "Pay Uncle Sam, he really hates that man", correct: false },
]
},
{
question:  "Finish the lyrics by Avicii : 'Wake me __",
answer: [
{ option: "up before you go go", correct: false },
{ option: "up inside", correct: false },
{ option: "up when September ends", correct: false },
{ option: "up when it's all over", correct: true},
]
},
{
question:  "The Vatican bank has the only ATM in the world that allows users to do what?",
answer: [
{ option: "A chance to win of blessing of your spawn by the Pope", correct: false },
{ option: "Perform transactions in Latin", correct: true},
{ option: "Get points towards heaven at the ends of days", correct: false },
{ option: "Dissolves of the sin of greed", correct: false },
]
},
  ]
  getQuizzes(){
    return this.quizzes;
  }
}
