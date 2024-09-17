'use client'
import Image from "next/image";
import React from "react";
import { Carousel } from 'react-responsive-carousel';
import 'react-responsive-carousel/lib/styles/carousel.min.css';
import './style.css';



const Carrossel = () => {
    return (
       <Carousel className="carrossel"
       showThumbs={false}
       showStatus={false}
       infiniteLoop={true}
       showArrows={true}
       emulateTouch={true}
       swipeable={true}
       useKeyboardArrows={true}
       autoPlay={true}
       interval={8000}
       transitionTime={500}
       centerMode={true}
       centerSlidePercentage={45}
       >
            <article className="card-carrossel">
                <Image src="/assets/ImagemTigre2.svg" alt="Imagem Tigre" width="276" height="249"></Image>    
                <h3 className="depoimento-carrossel">
                    “O fato de o catálogo de conectores da MuleSoft contemplar os principais ERPs do mercado foi um diferencial na hora escolhermos a solução.”                    </h3>
                <h3 className="paragrafo-carrossel">
                    EDUARDO MAFRA PEREIRA - ARQUITETO DE INTEGRAÇÕES DO GRUPO TIGRE                    </h3>
            </article>
            <article className="card-carrossel">
                <Image src="/assets/imagemVipal.svg" alt="Imagem Vipal" width="276" height="249"></Image>
                <h3 className="depoimento-carrossel">
                    “Com a implementação da solução da Salesforce, pudemos centralizar todos os dados de nossos clientes dos últimos cinco anos em uma única plataforma, possibilitando que nossas equipes comerciais tenham as informações mais importantes em mãos e sejam mais assertivas em suas abordagens.”                    </h3>
                <h3 className="paragrafo-carrossel">
                    LEANDRO RIGON, DIRETOR DE NEGÓCIOS INTERNACIONAIS DA VIPAL BORRACHAS.                    </h3>
            </article>
            <article className="card-carrossel">
                <Image src="/assets/imagemSumUp.svg" alt="Imagem SumUp" width="276" height="249"></Image>
                <h3 className="depoimento-carrossel">
                    “Para a SumUp, é extremamente importante fornecermos soluções de forma rápida para nossos clientes. Com o franco crescimento da nossa atuação e do nosso portfólio de produtos no país, a Salesforce foi a parceira perfeita, pois nos ajudou neste processo de automação e nos equipou com uma ferramenta escalável e que acompanha nosso desenvolvimento ao longo dos anos.”                    </h3>
                <h3 className="paragrafo-carrossel">
                    LUCAS SORANO, HEAD DE SALESFORCE NA SUMUP                    
                </h3>
            </article>
            <article className="card-carrossel">
                <Image src="/assets/imagemGympass.svg" alt="Imagem Gympass" width="276" height="249"></Image>
                <h3 className="depoimento-carrossel">
                    “Após a adoção de soluções Salesforce, pudemos trabalhar de forma muito mais objetiva e direcionada graças à qualidade dos dados e insights que as ferramentas nos oferecem.”
                </h3>
                <h3 className="paragrafo-carrossel">
                    MARINA MICHEL - DIRETORA DE GLOBAL SALES PROJECTS DO GYMPASS
                </h3>
            </article>
       </Carousel>
    );
   };
   
   export default Carrossel;