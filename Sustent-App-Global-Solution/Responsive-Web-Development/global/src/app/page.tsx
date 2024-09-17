import "../../public/css/home.css"
import Image from "next/image";
import plasticos from "../../public/assets/plasticos-removebg.png"
import login from "../../public/assets/Login.png"
import home from "../../public/assets/Home-Celularhome.png"
import scan from "../../public/assets/Scan-Celular.png"
import descricao from "../../public/assets/Descrição-Celular.png"
import localizacao from "../../public/assets/Localização-Celular.png"
import catador from "../../public/assets/Comunidade-Celular.png"
import Link from "next/link";

const Home = () => {
  return (
    <>
      <h2 className="titulo">Você quer saber mais sobre reciclagem?</h2>
      <section className="sessao">
        <article className="artigo">
          Existem diferentes tipos de plástico, como PET, PEAD, PVC, PEBD entre outros.
          <br/><br />
          Nem todo plástico pode ser usado no micro-ondas, para guardar alimentos ou reciclado.
          <br /><br />
          Você sabia que papel higienico e  papel toalha podem ser reciclados?
          <br /><br />
          Sabia que há um jeito correto de higienização que devemos ter com esses materiais recicláveis?
          <br /><br />
          É útil para o nosso dia a dia sabermos quais materiais podemos reutilizar, reciclar e como higienizar. Caso não ligue para essa parte, é de extrema importância que saiba os locais corretos para fazer o descarte!
        </article>
        <Image src={plasticos} width={400} height={300} alt="Embalagens de plástico"></Image>
      </section>
      <h2 className="titulo">Mas isso tudo é muita informação para decorar, né?! Por isso o nosso aplicativo <span className="marcar">SustentApp</span> está aqui para te ajudar!</h2>
      <div>
        <section className="section">
          <Image src={login} width={400} height={400} alt=""></Image>
          <p>Você realiza o seu login e então terá acesso ao sistema de Scan, além de notícias e outras informações sobre reciclagem.</p>
          <Image src={home} width={400} height={400} alt=""></Image>
        </section>
        <section className="section">
          <Image src={scan} width={400} height={400} alt=""></Image>
          <p>Após escanear o selo do material ou o código de barras, aparecerá várias informações sobre o material. Como se é reciclável ou não, como reciclar e orientações de higiene.</p>
          <Image src={descricao} width={400} height={400} alt=""></Image>
        </section>
        <section className="section">
          <Image src={localizacao} width={400} height={400} alt=""></Image>
          <p>Após isso, por meio da sua localização é possível encontrar cooperativas e catadores próximos. Caso escolha um catador, poderá combinar uma coleta.</p>
          <Image src={catador} width={400} height={400} alt=""></Image>
        </section>
      </div>
      <h2 className="titulo">Gostou do nosso aplicativo? Já quer garantir seu lugar ajudando a natureza? <Link href="/reciclagem">Então vem cá!</Link></h2>
    </>
  )
}

export default Home;
