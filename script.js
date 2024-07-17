let song;
let currentfolder;
function secondsToMinutesSeconds(seconds) {
    if (isNaN(seconds) || seconds < 0) {
        return "00:00";
    }

    const minutes = Math.floor(seconds / 60);
    const remainingSeconds = Math.floor(seconds % 60);

    const formattedMinutes = String(minutes).padStart(2, '0');
    const formattedSeconds = String(remainingSeconds).padStart(2, '0');

    return `${formattedMinutes}:${formattedSeconds}`;
}
let currentsong =new Audio();
async function getSong(folder){
    currentfolder=folder
    let a=await fetch(`/${folder}/`)
    let response=await a.text()
    // console.log(response)
     song=[];
    let div=document.createElement("div")
    div.innerHTML=response
    let as=div.getElementsByTagName("a")

    for (let index = 0; index < as.length; index++) {
        const element = as[index];
        if(element.href.endsWith(".mp3")){
            song.push(element.href.split(`/${folder}/`)[1])
        }
    }
    let songul=document.querySelector(".songlist").getElementsByTagName("ul")[0]
    songul.innerHTML=""
    for (const sing of song) {
        songul.innerHTML=songul.innerHTML+ `<li>
        <img class="invert" src="img/music.svg" alt="">
        <div class="info">
            <div >${sing.replaceAll("%20", " ")}</div>
            <div>Tushar</div>
        </div>
        <div class="playnow">
            <span>Play Now</span>
            <img class="invert" src="img/play.svg" alt="">
        </div>
    </li>`;
    }
    Array.from(document.querySelector(".songlist").getElementsByTagName("li")).forEach(e=>{
        e.addEventListener("click",element=>{    
        console.log(e.querySelector(".info").firstElementChild.innerHTML)
        playmusic(e.querySelector(".info").firstElementChild.innerHTML.trim())
        })
    })
    return song
}
const playmusic=(track,pause=false)=>{
    // let audio=new Audio("song/"+ track)
    currentsong.src=`${currentfolder}/`+ track
    if(!pause){
        currentsong.play()
        play.src="img/pause.svg"
    }
    document.querySelector(".songinfo").innerHTML=decodeURI(track)
    document.querySelector(".songtime").innerHTML="00:00 / 00:00"
    
}
async function displayAlbum(){
    let a=await fetch(`/song/`)
    let response=await a.text();
    let div=document.createElement("div")
    div.innerHTML=response;
    let anchor=div.getElementsByTagName("a")
    let cardContainer=document.querySelector(".cardContainer")
    let array= Array.from(anchor)
    for (let index = 0; index < array.length; index++) {
        const e= array[index];
        if(e.href.includes("/song") && !e.href.includes(".htaccess")){
        let folder=(e.href.split("/").slice(-2)[0])
        let a=await fetch(`/song/${folder}/info.json`)
        let response=await a.json();
        cardContainer.innerHTML=cardContainer.innerHTML+`<div data-folder="${folder}" class="card ">

        <div class="play">
            <img src="img/play.svg" alt="">
        </div>
            <img src="/song/${folder}/cover.jpeg" alt="">
            <h2>${response.title}</h2>
            <p>${response.description}</p>
    </div>`
        }
    }
    Array.from(document.getElementsByClassName("card")).forEach(e=>{
        e.addEventListener("click",async item=>{
            song=await getSong(`song/${item.currentTarget.dataset.folder}`)
            playmusic(song[0])
        })
    })
}
async function main(){
    await getSong("song/ncs")
    playmusic(song[0],true)

    displayAlbum()

    play.addEventListener("click",()=>{
        if(currentsong.paused){
            currentsong.play()
            play.src="img/pause.svg"
        }
        else{
            currentsong.pause()
            play.src="img/play.svg"
        }
    })

    currentsong.addEventListener("timeupdate",()=>{
        document.querySelector(".songtime").innerHTML=`${secondsToMinutesSeconds(currentsong.currentTime)} / ${secondsToMinutesSeconds(currentsong.duration)}`
        document.querySelector(".circle").style.left=(currentsong.currentTime / currentsong.duration) * 100 +"%";
    })
    //add an event listener to seek bar

    document.querySelector(".seekbar").addEventListener("click",e=>{
        let per=(e.offsetX/e.target.getBoundingClientRect().width)*100
        document.querySelector(".circle").style.left=per +"%";
        currentsong.currentTime=(currentsong.duration*per)/100

    })
    document.querySelector(".hamburger").addEventListener("click",()=>{
        document.querySelector(".left").style.left="0"
    })
    document.querySelector(".close").addEventListener("click",()=>{
        document.querySelector(".left").style.left="-130%"
    })
    prev.addEventListener("click",()=>{
        currentsong.pause();
        let idx=song.indexOf(currentsong.src.split("/").slice(-1)[0])
        if(idx-1>=0){
            playmusic(song[idx-1])
        }
    })
    next.addEventListener("click",()=>{
        console.log("next")
        let idx=song.indexOf(currentsong.src.split("/").slice(-1)[0])
        if(idx+1 < song.length){
            currentsong.pause();
            playmusic(song[idx+1])
        }
    })
    document.querySelector(".range").getElementsByTagName("input")[0].addEventListener("change",(e)=>{
        currentsong.volume=parseInt(e.target.value)/100
    })
    document.querySelector(".volume>img").addEventListener("click",e=>{
        if(e.target.src.includes("vol.svg")){
            e.target.src=e.target.src.replace("vol.svg","mute.svg");
            currentsong.volume=0;
            document.querySelector(".range").getElementsByTagName("input")[0].value=0;
        }
        else{
            e.target.src=e.target.src.replace("mute.svg","vol.svg");
            currentsong.volume=.10;
            document.querySelector(".range").getElementsByTagName("input")[0].value=10;
        }
    })
    
}
main()
