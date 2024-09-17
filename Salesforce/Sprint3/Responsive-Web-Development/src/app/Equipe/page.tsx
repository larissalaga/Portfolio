import Image from "next/image";
import Link from "next/link";
import './equipe.css';

const Equipe = () => {
  return(
    <>
      <div className="equipe">
        <h1 className="titulo-equipe">Equipe</h1>
        <section className="informacoes-equipe">
          <article className="informacoes-pessoais">
            <Image src="/assets/LarissaAraujoG.svg" alt="Foto Larissa Araujo" width="300" height="300" className="fotos"/>
            <section className="nomes-equipe">
              <span className="nome-rm-rede">
                <p>Larissa Araújo Gama A.</p>
                <p>RM 96496</p>
              </span>
              <button className="botao-contato-linkedin">
                  <Image src="/assets/linkLinkedIn.svg" alt="Ícone linkedin" width="30" height="30"/>
                  <Link href="https://www.linkedin.com/in/larissa-araujo-gama-alvarenga/" className="link-linkedin">LinkedIn</Link>
              </button>
            </section>
          </article>
          <article className="informacoes-pessoais-esquerda">
            <section className="nomes-equipe">
              <span className="nome-rm-rede-esquerda">
                <p>Larissa Lopes Oliveira</p>
                <p>RM 552628</p>
              </span>
              <button className="botao-contato-linkedin">
                  <Image src="/assets/linkLinkedIn.svg" alt="Ícone linkedin" width="30" height="30"/>
                  <Link href="https://www.linkedin.com/in/work-larissa-oliveira/" className="link-linkedin">LinkedIn</Link>
              </button>
            </section>
            <Image src="/assets/LarissaLopes.svg" alt="Foto Larissa Lopes" width="300" height="300" className="fotos"/>
          </article>
          <article className="informacoes-pessoais">
          <Image src="/assets/LunaFaustino.svg" alt="Foto Luna Faustino" width="300" height="300" className="fotos"/>
          <section className="nomes-equipe">
            <span className="nome-rm-rede">
              <p>Luna Faustino Lima</p>
              <p>RM 552473</p>
            </span>
            <button className="botao-contato-linkedin">
                <Image src="/assets/linkLinkedIn.svg" alt="Ícone linkedin" width="30" height="30"/>
                <Link href="https://www.linkedin.com/in/luna-faustino-343170193/" className="link-linkedin">LinkedIn</Link>
            </button>
          </section>
          </article>
        </section>
      </div>
      </>
  )
}
export default Equipe;